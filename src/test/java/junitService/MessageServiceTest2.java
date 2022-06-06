package junitService;

import junitRepository.MessageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
// bu annot, mockito uzantısını buraya yükleyerek JUnit'imi daha işlevsel hale getiriyor
public class MessageServiceTest2 {


    @Mock
    MessageRepository repository;

    @InjectMocks
    MessageService service; // yukarıda mock'ladığım bütün nesneleri, bu service'in içerisine enjekte ediyor

    @Test
    void getMessageWithLengthLessThanFive() throws SQLException {//MessageService class'ındaki bu methodu test etmek istiyorum.Fakat bu methodun içinde
        // repository objesinden gelen getMessage() bağımlılığı var bunu elimine etmem gerekiyor
        // bunu yapmanın 2 adımı var. 1. adımda o bağımlı repository objesini @Mock annot'u ile oluşturuoyurm. Aslında bu yöntem,
        //MessageServiceTest1 classında oluşturduğum MessageService service = mock(MessageService.class) komutunun AYNISI

        //  2. adımında ise oluşturduğum mocked repository objesini, test edilen method'un bulunduğu sınıf'a(class under test)
        //enjekte ediyorum. Böylece @Mock annot'u ile oluşturduğum hayali repo'yu, service class'ındaki methodu test etmek için
        // kullanabilir ve bağımlılığı kaldırmış olurum.


        //artık bağımlılığımı kaldırdığıma göre getMessageWithLessThanFive() methodunu çağırdığımda bana gerçek database'den
        //(MessageRepository class'ındaki List<> "Hello","Merhaba","Halo")  gelmeyecek. E testi nası yapıcam o zaman ? when()...thenReturn()...
        //methodunu kullanarak kendim yeni bir liste oluşturacağım ve ondan get edeceğim.  WHEN(repodaki getList çağırıldığında).
        //THENRETURN(
        // yeni liste getir o da şu liste =  List<>  "asdf","qwer","wwww"). Not: bunu yazdığımda repodaki getMessage'da throws olduğu için
        //bura da try catch'e alman gerekiyor şeklinde hata verecektir. try cath'e almamız lazım


        when(repository.getMessages()).thenReturn(Arrays.asList("asdf", "qwertw"));

        //artık getMessageWithLengthLessThanFive() methodumu bağımlılıklarından kutardım, DB'ye değil yeni oluşturduğum mocked List'e
        //("asdf","qwer","wwww") bağladıığma göre şimdi test aşamasına geçebilirim


        List<String> actualList = service.getMessageWithLengthLessThanFive();


        assertNotNull(actualList); // mesela listem not null olmasın diye bir test yazdım

        assertEquals(2, actualList.size()); // listemdeki kelimelerden 5 harften az olanları döndürüp yeni bir liste oluşturdum.
        // bu listenin eleman sayısı 2 mi diye testiyorum

    }


    @Test
    void exceptionTest() throws SQLException {// service'in getMessage()'ini çağırayım, ve SQL Excp. thro edeyim ve gelen listenin
        // durumunu test edicem

        when(repository.getMessages()).thenThrow(new SQLException());

        List<String> messages = service.getMessages(); // görüldüğü gibi service class'ından getMessage()'i çağırdım. ve when/then
        // ile ona bir SQLExcep throw ettirdim. getMessage() methodu bu throw'u
        //yakaladı ve catch kısmında yazıldığı gibi boş list döndürdü(Arrays.Aslist())

        assertEquals(0, messages.size());

    }


}
