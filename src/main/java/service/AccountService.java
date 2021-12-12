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

    public void deposit(Account account, double amount) {
        accountDao.deposit(account.getId(), amount);
    }

    public void withdraw(Account account, double amount) {
        accountDao.withdraw(account.getId(), amount);
    }
}
