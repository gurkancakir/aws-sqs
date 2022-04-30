package com.gurkan.awssqs.component;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class SQSMessageSender {

    private final QueueMessagingTemplate queueMessagingTemplate;

    public void send(String queueName, Object message) {
        queueMessagingTemplate.convertAndSend(queueName, message);
    }

    public void send(String queueName, Object message, Map<String, Object> headers) {
        queueMessagingTemplate.convertAndSend(queueName, message, headers);
    }
}
