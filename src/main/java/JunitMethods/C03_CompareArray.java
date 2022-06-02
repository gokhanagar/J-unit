package JunitMethods;

import java.util.Arrays;
import java.util.List;

public class C03_CompareArray {

    public <T> boolean compareTwoArrays(T[] a1, T[] a2) {

        Arrays.sort(a1);
        Arrays.sort(a2);

        if (Arrays.equals(a1, a2)) {
            return true;
        } else {
            return false;
        }

    }


}
