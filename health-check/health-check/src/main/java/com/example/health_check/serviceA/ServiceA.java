package com.example.health_check.serviceA;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ServiceA {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public ServiceA(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 5000)
    public void sendAliveMessage() {
        kafkaTemplate.send("health-check", "I'm alive");
    }
}
