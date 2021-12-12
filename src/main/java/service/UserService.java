package service;

import dao.UserDao;
import model.User;

/**
 * @author Negin Mousavi
 */
public class UserService {
    UserDao userDao = new UserDao();

    public User findByFirstName(String name) {
        return userDao.findByFirstName(name);
    }

    public User findByLastName(String name) {
        return userDao.findByLastName(name);
    }
}
