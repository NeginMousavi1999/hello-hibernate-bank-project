package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Negin Mousavi
 */
public class BaseDao {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
}
