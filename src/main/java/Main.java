import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

        String userName;

        session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "Select user.firstName from User user where user.nationalCode=:code";
            System.out.println(hql);
            Query query = session.createQuery(hql);
            query.setParameter("code", "0021899436");
            List result = query.list();

            System.out.println("result set: " + result);

            Iterator iterator = result.iterator();
            while (iterator.hasNext()) {
                userName = (String) iterator.next();
            }
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }
}
