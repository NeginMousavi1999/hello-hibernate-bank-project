package dao;

import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author Negin Mousavi
 */
public class UserDao extends BaseDao {
    public User findByFirstName(String name) {
        Session session = sessionFactory.openSession();
        List<User> result = null;
        try {
            session.beginTransaction();
            String hql = "from User user where user.firstName=:name";
            System.out.println(hql);
            Query<User> query = session.createQuery(hql);
            query.setParameter("name", name);
            result = query.list();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        assert result != null;
        return result.get(0);
    }

    public User findByLastName(String name) {
        Session session = sessionFactory.openSession();
        List<User> result = null;
        try {
            session.beginTransaction();
            String hql = "from User user where user.lastName=:name";
            System.out.println(hql);
            Query<User> query = session.createQuery(hql);
            query.setParameter("name", name);
            result = query.list();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        assert result != null;
        return result.get(0);
    }

    public User findByCartNumber(String name) {//TODO
        return new User();
    }
}
