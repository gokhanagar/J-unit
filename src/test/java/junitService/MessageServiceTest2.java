package junitService;

import junitRepository.MessageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MessageServiceTest2 {

    @Mock
    MessageRepository repository;

    @InjectMocks
    MessageService service;

    @Test
    void testGetMessageWithLengthLessThanFive() {

        when(repository.getMessages()).thenReturn(Arrays.asList("Junit", "Mockito", "test", "Message"));
        List<String> actualList = service.getMessageWithLengthLessThanFive();

        assertNotNull(actualList);
        assertEquals(2, actualList.size());

    }

    /*
    @Test
    void testException() throws SQLException {
        when(repository.getMessages()).thenThrow(new SQLException("Connection Exception"));

        List<String> messages = service.getMessages();

        assertNotNull(messages);
        assertEquals(0,messages.size());
    }
    */


}
