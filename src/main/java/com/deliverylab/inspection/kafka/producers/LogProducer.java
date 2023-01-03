package com.deliverylab.inspection.kafka.producers;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import com.deliverylab.inspection.payload.request.ProductMessage;

import java.io.Serializable;

@Slf4j
@NoArgsConstructor
@Component
public class LogProducer {
    final String productTopic = "log";

    @Autowired
    private KafkaTemplate<String, Serializable> kafkaTemplate;

    public void send(ProductMessage message) throws Exception {
        kafkaTemplate.send(productTopic, message).thenAcceptAsync((SendResult<String, Serializable> result) -> {
            log.info("Message sent successfully with offset = {}", result.getRecordMetadata().offset());
        }).exceptionally(throwable -> {
            System.out.println("exception occurred!!");
            return null;
        });
    }
}
