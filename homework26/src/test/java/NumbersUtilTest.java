import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

@DisplayName(value = "NumbersUtil is working when")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class NumbersUtilTest {
    private final NumbersUtil numbersUtil = new NumbersUtil();

    @Nested
    @DisplayName("gcd is working")
    public class ForGcd {
        @ParameterizedTest (name = "throws exception on {0} and {1}")
        @CsvSource({"-7, 13", "25, -35", "0, 113", "-2, -3", "71, 0"})
        public void on_negative_numbers_or_0_throws_exception(int number1, int number2) {
            assertThrows(IllegalArgumentException.class, () -> numbersUtil.gcd(number1, number2));
        }

        @ParameterizedTest(name = "returns {0} on {0} and {0}")
        @ValueSource(ints = {1, 2, 5, 35, 17, 111})
        public void on_equal_numbers_return_the_same_number(int number) {
            assertEquals(number, numbersUtil.gcd(number, number));
        }

        @ParameterizedTest (name = "returns 1 on {0} and {1}")
        @CsvSource({"7, 13", "111, 113", "2, 3", "71, 37"})
        public void on_prime_numbers_return_1(int number1, int number2) {
            assertEquals(1, numbersUtil.gcd(number1, number2));
        }

        @ParameterizedTest (name = "returns {0} on {1} and {2}")
        @CsvSource({"6, 18, 6", "3, 9, 12", "5, 25, 35", "7, 35, 63"})
        public void on_positive_numbers_return_right_number(int result, int number1, int number2) {
            assertEquals(result, numbersUtil.gcd(number1, number2));
        }
    }








}