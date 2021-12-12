import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author Negin Mousavi
 */
public class MainGenerateNumberStringTest {

    @ParameterizedTest
    @CsvSource({"4, 4444", "7, 7777777", "10, 1000000000"})
    void giveInputs_WhenGenerateNumberStringCalls_ThenResponseReturn(String digit, int bound) {
        String result = Main.generateNumberString(digit, bound);
        Assertions.assertEquals(Integer.parseInt(digit), result.length());
    }
}
