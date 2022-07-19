package com.example.kafkajsontest.service;

import com.example.kafkajsontest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void saveCreateUserLog(User user){
        this.kafkaTemplate.send("newtop", user);
    }
}
