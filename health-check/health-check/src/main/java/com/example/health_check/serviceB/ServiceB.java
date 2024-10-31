package com.example.health_check.serviceB;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Service
public class ServiceB {
    private final MessageRepository messageRepository;

    public ServiceB(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @KafkaListener(topics = "health-check", groupId = "group_id")
    public void listen(String message) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessage(message);
        messageEntity.setTimestamp(System.currentTimeMillis());
        messageRepository.save(messageEntity);
    }
}

