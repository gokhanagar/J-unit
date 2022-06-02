package junit5Tutorials;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class j07_GroupingTest {

    @Nested
    class multiplyWithNonZero {
        @ParameterizedTest
        @CsvSource(value = {"-15,-5,3", "20,5,4", "45,9,5"})
        void multiplyTest(int exp, int x, int y) {
            assertEquals(exp, Math.multiplyExact(x, y));
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"0,6,0", "0,8,0", "0,0,9"})
    void multiplyTestWithZero(int exp, int x, int y) {
        assertEquals(exp, Math.multiplyExact(x, y));
    }

    @Nested
    class addTest {
        @ParameterizedTest
        @CsvSource(value = {"-5,-10,5", "45,25,20", "-15,30,-45"})
        void addTest(int exp, int x, int y) {
            assertEquals(exp, Math.addExact(x, y));
        }

        @ParameterizedTest
        @CsvSource(value = {"0,4,-4", "0,10,-10"})
        void addTestWithZero(int exp, int x, int y) {
            assertEquals(exp, Math.addExact(x, y));
        }


    }


}
