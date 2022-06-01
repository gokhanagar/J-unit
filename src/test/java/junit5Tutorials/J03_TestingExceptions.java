package junit5Tutorials;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class J03_TestingExceptions {

    /*
    assertThrow() method'u --> belirtilen islemin(executable) belirtilen turde bir Exception olusturup olusturmadigini
    test eder
        Dolayisiyla 2 paremetre alir
        1. parametre --> expected(beklenen) Exception(istisna)turu,
        2. parametre --> actual(olusacak) calistirilacak olan islemdir.
    Eger islem belirtilen turde bir exception olusturursa test basarli olur. TEST PASSED
    ama exception olusmaz ise veya turu yanlis olursa test basarisiz olur. TEST FAILED
    Exception.io turunde parent-child iliskisi var ise yine test basarili sayilir.
     */

    @Test
    void testException1() {
        // String strSayi ="1453";
        //String strSayi ="14a53"; //NumberFormatException
        //Integer intSayi = Integer.parseInt(strSayi); //1453

        assertThrows(NumberFormatException.class, () -> Integer.parseInt("14a3"));//passed
        //assertThrows(NumberFormatException.class, ()->Integer.parseInt("143"));//failed
        assertThrows(Exception.class, () -> Integer.parseInt("14a3"));
        //passed --> Exception parentNumberFormatException child

    }


    @Test
    @DisplayName("NullPointerException TEST")
    void testException2() {
        String str = null;

        //str.length();
        assertThrows(NullPointerException.class, () -> str.length()); //passed
        assertThrows(NumberFormatException.class, () -> str.length()); //failed --> farkli tur exception firlatir

    }

    @Test
        //@DisplayName("NullPointerException TEST")
    void testException3() {

        assertThrows(IllegalArgumentException.class, () -> yasYazdir(-2));
    }

    void yasYazdir(int yas) {
        if (yas < 0) {
            throw new IllegalArgumentException();
        } else System.out.println(yas);
    }


}
