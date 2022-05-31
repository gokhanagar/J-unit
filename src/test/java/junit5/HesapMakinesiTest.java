package junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HesapMakinesiTest {

    @Test
    @DisplayName("topla methodu testi")
//kullanici veya yonetici bilgilendirmesi test'e etiket verir.
    void topla() {

        assertEquals(3, HesapMakinesi.topla(1, 2));
        assertEquals(4, HesapMakinesi.topla(-8, 12));
        assertEquals(-1, HesapMakinesi.topla(1, -2));
        // assertEquals(3,HesapMakinesi.topla(1,12));
    }

    @Test
    @DisplayName("carpma methodu testi")
    void carp() {
        assertEquals(3, HesapMakinesi.carp(1, 3));
        assertEquals(-24, HesapMakinesi.carp(-8, 3));
        assertEquals(8, HesapMakinesi.carp(4, 2));
    }
}