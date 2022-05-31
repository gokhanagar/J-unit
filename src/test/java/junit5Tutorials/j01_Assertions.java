package junit5Tutorials;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class j01_Assertions {

    @Test
    @DisplayName("ToAssert testi")
    void testToAssert(){
        int actual = "hakan".length(); //5
        int expected =5;

        assertEquals(expected, actual,"beklenen ve gercek deger esit");

        //inLine style: her zaman kullanilmaz basit teste ve kod kozmetigine aykiridir.
        assertEquals(5,"hakan".length(),"bu yontem cok kullanilmaz");

        expected=4;
        assertNotEquals(expected,actual,"beklenen ve gercek deger esit degil");

        expected=5;
        assertTrue(expected==actual,"sart saglanmadi");

        expected=5;
        assertFalse(expected!=actual,"sart saglandi");

    }

    @Test
    @DisplayName("ToConvertUpper test")
    void testToConvertUpper(){

      String expected = "BASRI";
      String actual = "basri".toUpperCase();

      assertEquals(expected,actual); //passed

      assertTrue(expected.equals(actual)); //passed
      assertFalse(!actual.equals(expected)); //passed

      actual=null;
      assertNull(actual, "actual deger null degil");//passed

      //assertNotNull(actual, "actual deger null"); failed
      actual ="kenan";
      assertNotNull(actual, "actual deger null");//paseed

    }

    @Test
    @DisplayName("ToContain testi")
    void testToContain(){

        boolean actual = "erdem".contains("hi"); //false
        boolean expected=false;
        assertEquals(expected, actual,"degerler esit degil");
    }

    @Test
    @DisplayName("arrays test")
    void testWithArrays() {
        String str="junit ile testler";
        String actual[] = str.split(" ");
        String expected[] = {"junit","ile","testler"};

        assertArrayEquals(expected, actual,"array'ler esit degil");


    }

















}
