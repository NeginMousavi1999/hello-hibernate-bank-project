package dao;

import model.Account;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Negin Mousavi
 */
public class AccountDao extends BaseDao {
    public void save(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = account.getUser();
        session.saveOrUpdate(user);
        user.getAccounts().add(account);
        transaction.commit();
        session.close();
    }
}
