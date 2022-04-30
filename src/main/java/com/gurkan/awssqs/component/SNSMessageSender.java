package com.gurkan.awssqs.component;

import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SNSMessageSender {

    private final NotificationMessagingTemplate notificationMessagingTemplate;

    public void send(String topicName, Object message, String subject) {
        notificationMessagingTemplate.sendNotification(topicName, message, subject);
    }
}