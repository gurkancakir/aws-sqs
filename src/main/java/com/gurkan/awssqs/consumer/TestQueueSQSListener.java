package com.gurkan.awssqs.consumer;

import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Slf4j
public class TestQueueSQSListener {

    @SqsListener("test-queue")
    public void receiveMessage(String message) {
        log.info("Received message: {}", message);
    }
}
