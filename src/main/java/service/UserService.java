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

    public User findByCartNumber(String name) {
        return userDao.findByCartNumber(name);
    }

    public void editFirstName(User user, String newValue) {
        userDao.updateFirstName(user.getId(), newValue);
    }

    public void editLastName(User user, String newValue) {
        userDao.updateLastName(user.getId(), newValue);
    }

    public void editNationalCode(User user, String newValue) {
        userDao.updateNationalCode(user.getId(), newValue);
    }
}
