package junitService;

import junitRepository.MessageRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class MessageService {

    private MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public List<String> getMessages() throws SQLException {
        return repository.getMessages();


    }

    public List<String> getMessageWithLengthLessThanFive(){
      return  repository.getMessages().
              stream().
              filter(m->m.length()>5).
              collect(Collectors.toList());
    }

    public void addMessage(String message){
        repository.addMessage(message);
    }

    public void removeMessage(String message){
        repository.removeMessage(message);
    }


































}
