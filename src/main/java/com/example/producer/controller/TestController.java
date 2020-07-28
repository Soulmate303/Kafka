package com.example.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @RequestMapping(value = "/kafka/normal/{message}", method = RequestMethod.POST)
    public void sendMessage1(@PathVariable("message") String normalMessage) {
        kafkaTemplate.send("student-score", normalMessage);
        System.out.println(normalMessage);
    }

}
