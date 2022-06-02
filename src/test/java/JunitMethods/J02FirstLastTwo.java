package JunitMethods;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class J02FirstLastTwo {

    C02_FirstLastTwoSame obj = new C02_FirstLastTwoSame();

    @ParameterizedTest
    @CsvSource(value = {"true,SDSD", "false,GHHG", "true,TYuiuTY"})
    void checkFirstLAstTwo(boolean exp, String str) {

        assertEquals(exp, obj.check_First_Last_Two(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"GHGH", "GH"})
    void checkFirstLAstTwo2(String str) {

        assertTrue(obj.check_First_Last_Two(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"TYTY", "JKKJ"})
    void checkFirstLAstTwo3(String str) {

        assertFalse(obj.check_First_Last_Two(str));
    }


}
