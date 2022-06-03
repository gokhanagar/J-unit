package JunitMethods;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTimeout;

class J04_SortArraysInASpecifiedTimeTest {

    @Test
    void sortArraysInASpecifiedTime() {

        C04_SortArraysInASpecifiedTime obj = new C04_SortArraysInASpecifiedTime();
        assertTimeout(Duration.ofSeconds(5), () ->
                IntStream.rangeClosed(1, 10000).forEach(t -> obj.sortArraysInASpecifiedTime()));

    }

    C04_SortArraysInASpecifiedTime obj = new C04_SortArraysInASpecifiedTime();

    @RepeatedTest(1000)
    void sortArraysInASpecifiedTime2() {
        assertTimeout(Duration.ofSeconds(5), () -> obj.sortArraysInASpecifiedTime());
    }
}