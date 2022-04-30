package com.gurkan.awssqs.controller;

import com.gurkan.awssqs.component.SQSMessageSender;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class QueueProducerController {

    private final SQSMessageSender sqsMessageSender;

    @PostMapping("topic/{queueName}/send")
    public void sendMessageToTopic(@PathVariable("queueName") String queueName, String message) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("senderId", "custom-app");
        sqsMessageSender.send(queueName, message, headers);
    }
}
