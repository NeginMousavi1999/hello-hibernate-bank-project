import model.Account;
import model.AccountType;
import model.User;
import model.UserType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import service.UserService;

import java.util.Date;

/**
 * @author Negin Mousavi
 */
public class Main {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    static UserService userService = new UserService();

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

/*        System.out.println(userService.findByFirstName("jack"));
        System.out.println(userService.findByLastName("ho"));*/


/*        String userName;

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
        }*/
    }
}
