package com.deliverylab.inspection.services;

import com.deliverylab.inspection.kafka.messages.LogMessage;
import com.deliverylab.inspection.kafka.producers.LogProducer;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LogService {
    @Autowired
    private LogProducer logProducer;

    public void sendMessage(LogMessage msg) throws Exception {
        log.info("[ProductService] send product to topic, message: " + msg.toString());
        logProducer.send(msg);
    }
}