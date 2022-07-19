package com.example.kafkajsontest.controller;

import com.example.kafkajsontest.model.User;
import com.example.kafkajsontest.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class KafkaProducerController {

    private final KafkaProducerService producerService;

    @Autowired
    public KafkaProducerController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping(value = "/createUser")
    public void sendMessageToKafkaTopic(
            @RequestParam("userId") long userId,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
            User user = new User();
            user.setUserId(userId);
            user.setFirstname(firstName);
            user.setLastName(lastName);

            this.producerService.saveCreateUserLog(user);
    }
}
