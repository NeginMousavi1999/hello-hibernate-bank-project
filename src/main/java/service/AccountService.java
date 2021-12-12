package service;

import dao.AccountDao;
import model.Account;

/**
 * @author Negin Mousavi
 */
public class AccountService {
    AccountDao accountDao = new AccountDao();

    public void save(Account account) {
        accountDao.save(account);
    }
}
