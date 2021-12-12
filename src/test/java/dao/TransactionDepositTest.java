package dao;

import model.Account;
import model.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author Negin Mousavi
 */
public class TransactionDepositTest {

    Transaction transaction = new Transaction();

    @BeforeEach
    void init() {
        transaction.setAccount(new Account());
    }

    @ParameterizedTest
    @CsvSource({"1000, 2000", "1500, 2500"})
    void giveAmount_WhenDepositCalls_ThenResponseReturn(double amount, double expect) {
        transaction.getAccount().setBalance(1000);
        double result = transaction.deposit(amount);
        Assertions.assertEquals(expect, result);
    }
}
