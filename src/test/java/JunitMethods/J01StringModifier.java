package JunitMethods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class J01StringModifier {

    C01StringModifier strModifier;

    @BeforeEach
    void setUp() {
        strModifier = new C01StringModifier();
        System.out.println("@beforeEach is executed");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach is executed");
    }

    @ParameterizedTest
    @CsvSource(value = {"BD,CCBD", "BA,CBA"})
    void deleteStr(String expected, String str) {

        assertEquals(expected, strModifier.deleteStr(str));
        System.out.println("Executed");
    }


}
