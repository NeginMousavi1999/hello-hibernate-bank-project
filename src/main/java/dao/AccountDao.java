package dao;

import enumeration.TransactionType;
import model.Account;
import model.User;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * @author Negin Mousavi
 */
public class AccountDao extends BaseDao {
    public void save(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.load(User.class, account.getUser().getId());
        try {
            user.getFirstName();
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
            user = account.getUser();
        }
        user.getAccounts().add(account);
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    public void deposit(int id, double amount) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        model.Transaction accTransaction = new model.Transaction();
        Account account = session.load(Account.class, id);
        accTransaction.setAccount(account);
        accTransaction.setAmount(amount);
        accTransaction.setTransactionType(TransactionType.DEPOSIT);
        accTransaction.setDate(new Date());
        accTransaction.deposit();
        session.persist(accTransaction);
        transaction.commit();
        session.close();
    }

    public void withdraw(int id, double amount) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Account account = session.load(Account.class, id);
        model.Transaction accTransaction = new model.Transaction();
        accTransaction.setAccount(account);
        accTransaction.setAmount(amount);
        accTransaction.setTransactionType(TransactionType.WITHDRAW);
        accTransaction.setDate(new Date());
        accTransaction.withdraw();
        session.persist(accTransaction);
        transaction.commit();
        session.close();
    }
}
