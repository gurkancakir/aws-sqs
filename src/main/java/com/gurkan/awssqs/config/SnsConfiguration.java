package com.gurkan.awssqs.config;

import com.amazonaws.services.sns.AmazonSNS;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnsConfiguration {

    @Bean
    public NotificationMessagingTemplate notificationMessagingTemplate(AmazonSNS amazonSNS) {
        return new NotificationMessagingTemplate(amazonSNS);
    }
}
