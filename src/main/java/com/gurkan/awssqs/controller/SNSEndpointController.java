package com.gurkan.awssqs.controller;

import io.awspring.cloud.messaging.config.annotation.NotificationMessage;
import io.awspring.cloud.messaging.config.annotation.NotificationSubject;
import io.awspring.cloud.messaging.endpoint.NotificationStatus;
import io.awspring.cloud.messaging.endpoint.annotation.NotificationMessageMapping;
import io.awspring.cloud.messaging.endpoint.annotation.NotificationSubscriptionMapping;
import io.awspring.cloud.messaging.endpoint.annotation.NotificationUnsubscribeConfirmationMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic-subscriber")
@Slf4j
public class SNSEndpointController {

    @NotificationMessageMapping
    public void receiveNotification(@NotificationMessage String message, @NotificationSubject String subject) {
        log.info("Received message: {}, having subject: {}", message, subject);
    }

    @NotificationUnsubscribeConfirmationMapping
    public void confirmSubscriptionMessage(NotificationStatus notificationStatus) {
        log.info("Unsubscribed from Topic");
        notificationStatus.confirmSubscription();
    }

    @NotificationSubscriptionMapping
    public void confirmUnsubscribeMessage(NotificationStatus notificationStatus) {
        log.info("Subscribed to Topic");
        notificationStatus.confirmSubscription();
    }
}
