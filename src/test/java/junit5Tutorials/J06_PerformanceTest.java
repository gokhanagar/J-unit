package junit5Tutorials;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class J06_PerformanceTest {

    @Test
        //@Disabled testin calismamasini saglar.
    void testPerformance() {

        assertTimeout(Duration.ofSeconds(10), () -> IntStream.rangeClosed(1, 5000).forEach(System.out::println));
    }

    @Test
    void testPerformance2() {

        assertTimeout(Duration.ofSeconds(2), () ->
                IntStream.rangeClosed(1, 6000).reduce((x, y) -> Math.addExact(x, y)));
    }


}
