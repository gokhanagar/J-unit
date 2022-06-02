package junit5Tutorials;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class J04_ParameterizedTest {


    @ParameterizedTest
    @ValueSource(strings = {"sadf", "asd", "a", "asdzxc"})
    void testLength(String str) {

        assertTrue(str.length() > 0);
    }


    @ParameterizedTest
    @CsvSource(value = {
            "MERHABA, merhaba",
            "JAVA, java",
            "HAVA, hava",

    })
    void upperCaseTest2(String s1, String s2) {
        assertEquals(s1, s2.toUpperCase());
    }

    @ParameterizedTest
    @CsvSource(value = {"true,hello,o", "true,junit,u", "false,merhaba,z"})
    void containsTest(Boolean b1, String s1, String s2) {

        assertEquals(b1, s1.contains(s2));
    }


}
