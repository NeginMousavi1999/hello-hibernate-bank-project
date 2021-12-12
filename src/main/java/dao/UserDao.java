package dao;

import model.Update;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

/**
 * @author Negin Mousavi
 */
public class UserDao extends BaseDao {
    public User findByFirstName(String name) {
        Session session = sessionFactory.openSession();
        List<User> result;
        session.beginTransaction();
        String hql = "from User user where user.firstName=:name";
        System.out.println(hql);
        Query<User> query = session.createQuery(hql);
        query.setParameter("name", name);
        result = query.list();
        assert result != null;
        return result.get(0);
    }

    public User findByLastName(String name) {
        Session session = sessionFactory.openSession();
        List<User> result;
        session.beginTransaction();
        String hql = "from User user where user.lastName=:name";
        System.out.println(hql);
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("name", name);
        result = query.list();
        assert result != null;
        return result.get(0);
    }

    public User findByCartNumber(String nationalCode) {
        Session session = sessionFactory.openSession();
        List<User> result;
        session.beginTransaction();
        String hql = "from User user where user.nationalCode=:nationalCode";
        System.out.println(hql);
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("nationalCode", nationalCode);
        result = query.list();
        assert result != null;
        return result.get(0);
    }

    public void updateFirstName(int id, String value) {
        Update update = new Update();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.load(User.class, id);
        update.setUser(user);
        update.setMessage(String.format("changing name to %s", value));
        update.setUpdateTime(new Date());
        user.setFirstName(value);
        session.save(update);
        transaction.commit();
        session.close();
    }

    public void updateLastName(int id, String value) {
        Update update = new Update();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.load(User.class, id);
        update.setUser(user);
        update.setMessage(String.format("changing last name to %s", value));
        update.setUpdateTime(new Date());
        user.setLastName(value);
        session.save(update);
        transaction.commit();
        session.close();
    }

    public void updateNationalCode(int id, String value) {
        Update update = new Update();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.load(User.class, id);
        update.setUser(user);
        update.setMessage(String.format("changing national code to %s", value));
        update.setUpdateTime(new Date());
        user.setNationalCode(value);
        session.save(update);
        transaction.commit();
        session.close();
    }
}
