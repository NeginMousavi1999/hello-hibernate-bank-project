package dao;

import model.Account;
import model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Negin Mousavi
 */
public class TransactionWithdrawTest {

    Transaction transaction = new Transaction();

    @BeforeEach
    void init() {
        transaction.setAccount(new Account());
    }

    @ParameterizedTest
    @CsvSource({"1000, 1000", "1500, 500"})
    void giveAmount_WhenWithdrawCalls_ThenResponseReturn(double amount, double expect) {
        transaction.setAmount(amount);
        transaction.getAccount().setBalance(2000);
        double result = transaction.withdraw();
        assertEquals(expect, result);
    }

    @Test
    void givenAmountLessThanBalance_WhenWithdrawCalls_ThenExceptionResponseReturn() {
        transaction.setAmount(2500);
        transaction.getAccount().setBalance(2000);
        Exception exception = assertThrows(RuntimeException.class, () -> transaction.withdraw());
        assertEquals("balance is not enough", exception.getMessage());
    }
}
