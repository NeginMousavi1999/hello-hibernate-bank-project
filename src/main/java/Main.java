import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * @author Negin Mousavi
 */
public class Main {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {

        User user = new User();
        user.setCreationDate(new Date());
        user.setFirstName("jack");
        user.setLastName("ho");
        user.setNationalCode("0021899436");
        user.setType(UserType.GOOD_DEALER);

        Account account = new Account();
        account.setAccountNumber("002211");
        account.setBalance(25000);
        account.setCartNumber("32165412");
        account.setCvv2("2741");
        account.setOpeningDate(new Date());
        account.setType(AccountType.CURRENT);
        account.setUser(user);
        user.getAccounts().add(account);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        System.out.println(session.get(User.class, 1));
        sessionFactory.close();
    }
}
