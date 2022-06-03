package junitService;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;


public class MessageServiceTest1 {
/*Birim testi sadece bir birimi test eder, o nedenle bagimliliklarin izole edilmesi gerekir.
Boylece bagimliliklarin yan etkilerinin onlenmesi saglanir.
Gercek nesneler ortaya beklenmedik durumlara neden olabilir.
Gercek nesneler yavas calisabilir ve zor bir sekilde yapilandirilir
Gercek nesneler tekrar edilebilir olmayabilir
Java da mocking islemlerini yapabilmek icin Mockito, JMockit ve EasyMock
kutuphaneler kullanilir.
 */

    @Test
    void addMessage() {
        MessageService service = mock(MessageService.class);

        service.addMessage("Merhaba");
        service.addMessage("Merhaba");
        service.addMessage("Mockito");

        verify(service).addMessage(("Merhaba"));
        //verify(service,times(2)).addMessage("Merhaba");
        verify(service, atLeast(2)).addMessage("Merhaba");
    }

    @Test
    void howManyCallTest() {
        MessageService service = mock(MessageService.class);

        service.addMessage("Merhaba");
        service.addMessage("Merhaba");
        service.addMessage("Mockito");


        //verify(service,times(2)).addMessage("Merhaba");
        verify(service, never()).removeMessage(any());
        //verify(service,atLeast(2)).addMessage("Merhaba");
    }

    @Test
    void callOrderTest() {
        MessageService service = mock(MessageService.class);

        service.addMessage("Merhaba");
        service.addMessage("Merhaba");
        service.addMessage("Mockito");

        InOrder inOrder = inOrder(service);

        inOrder.verify(service).addMessage("Merhaba");
        inOrder.verify(service).addMessage("Mockito");

    }


}
