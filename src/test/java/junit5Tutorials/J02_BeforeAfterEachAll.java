package junit5Tutorials;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class J02_BeforeAfterEachAll {

    /*@BeforeEach anotation  kullanilan bir method, her test method'u calismadan once calistirilir.
    Bu ozelligi sayesinde test verilerinin ayarlanmasi(baslatilmasi) icin kullanilabilir

    @AfterEach anotation kullanilan bir method, her test method'u bittikten sonra calistirilir.
    Bu ozelligi sayesinde test verilerinin temizlenmesi icin kullanilabilir

    @BeforeEach veya @AfterEach anotasyonunda yazim sirasi onemli degildir. HAngisi once yazilirsa yazilsin
    java once @BeforeEach compile eder sonra @AfterEach compile eder.
     */

    /*
    @BeforeAll tum test methodlarindan once calisan bir method olusturmak icn kullanilir.
    Dolayisiyla veritabani iceren bir test isleminde ilk olarak veritabanina baglanmak gerekeceginden @BeforeAll
    annotation ile bir method tanimlanarak ilk olarak veritabanina baglanma prosedur isletilebilir

    @AfterAll ile tum test metotlari bittikten sonra calisan bir metot olusturulabilir
    Bu ozelligi sayesinde testler bittikten sonra veritabani oturumu kapatilabilir

    @BeforeAll ve @AfterAll annotation kullanildigi methodlar static olmalidir.
     */

    @AfterAll
    static void veriTabaniBaglantiKapat() {

        System.out.println("AfterAll ->> veri tabani baglantisi kapatildi");
    }

    @BeforeAll
    static void veriTabaniBaglantiKur() {

        System.out.println("@BeforeAll --> veri tabani baglantisi kuruldu.");
    }

    @AfterEach
    void clean() {
        str = "";
        System.out.println("@AfterEach --> setup method run edildi");
    }


    @BeforeEach
    void setUp(TestInfo info) { //TestInfo--> @DisplayName: annotaion veriyi return eder.
        str = "Java ogrenenler";
        System.out.println("@BeforeEach --> setup method run edildi" + info.getDisplayName());
    }

    String str = "";

    @Test
    @DisplayName("length method test")
    void testStringLength() {

        int actual = str.length();
        int expected = 15;
        assertEquals(expected, actual, "degerler esit degil");
        System.out.println("TEST 1 --> length method calistirildi");

    }

    @Test
    @DisplayName("arrays test")
    void testWithArrays() {

        String actual[] = str.split(" ");
        String expected[] = {"Java", "ogrenenler"};

        assertArrayEquals(expected, actual, "array'ler esit degil");
        assertTrue(Arrays.equals(expected, actual));
        System.out.println("TEST 2 --> array method calistirildi");

    }

    @Test
    void testToFindMin(){
        assertTrue(5== Math.min(5,15));
        assertFalse(3==Math.min(6,9));
    }




}
