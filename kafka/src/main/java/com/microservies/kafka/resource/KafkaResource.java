package com.microservies.kafka.resource;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("kafka")
public class KafkaResource {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("publish")
    private ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaTemplate.send("topic1",message);
        return ResponseEntity.ok("Message sent");
    }

}
