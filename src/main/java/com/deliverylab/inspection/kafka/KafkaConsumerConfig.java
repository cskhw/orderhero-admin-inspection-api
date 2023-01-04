package com.deliverylab.inspection.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import com.deliverylab.inspection.kafka.messages.LogMessage;

@Configuration
public class KafkaConsumerConfig {
    @Value(value = "${kafka.baseURL}")
    private String baseURL;

    @Autowired
    private KafkaFactory kafkaFactory;

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, LogMessage> logKafkaListenerContainerFactory() throws Exception {
        return kafkaFactory.kafkaListenerContainerFactory(LogMessage.class);
    }
}