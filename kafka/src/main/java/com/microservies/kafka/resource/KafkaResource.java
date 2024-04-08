package com.microservies.kafka.resource;

import com.microservies.kafka.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("kafka")
public class KafkaResource {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("publish")
    private ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaTemplate.send("topic1",message);
        return ResponseEntity.ok("Message sent : " + message);
    }

    @GetMapping("publish2")
    private ResponseEntity<String> publish2(@RequestParam("fName") String fName, @RequestParam("lName") String lName){
        User user = new User(fName, lName);
        Message<User> message = MessageBuilder
                .withPayload(user)
                        .setHeader(KafkaHeaders.TOPIC,"topic2")
                                .build();
        kafkaTemplate.send("topic2",message);
        return ResponseEntity.ok("Message sent : " + user);
    }

}
