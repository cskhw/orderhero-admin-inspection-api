package com.deliverylab.inspection.kafka.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.deliverylab.inspection.kafka.messages.LogMessage;

@Slf4j
@Service
public class LogListener {
    @KafkaListener(topics = "log", containerFactory = "logKafkaListenerContainerFactory")
    public void newLogListener(LogMessage msg) {
        log.info("Get request from Front 'save log'" + msg.toString());
    }
}