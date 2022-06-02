package junit5Tutorials;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class J05_RepeatTest {

    @RepeatedTest(10)
    void subStringTest() {
        assertEquals("Java", "Java is a great language".substring(0, 4));
        System.out.println("subStringTest() calisti");
    }

    @RepeatedTest(5)
    void repeatedTest(TestInfo info) {
        assertEquals(10, Math.addExact(5, 5), "1+1 must equal 10");
    }

    static int x = 2;
    static int y = 4;
    static int result = 6;

    @RepeatedTest(20)
    void addExactTest() {
        assertEquals(result, Math.addExact(x, y));

        System.out.println("Result: " + result);
        y++;
        x++;
        result += 2;
    }


}
