package com.deliverylab.inspection.services;

import com.deliverylab.inspection.kafka.producers.ProductProducer;
import com.deliverylab.inspection.payload.request.ProductMessage;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductService {
    @Autowired
    private ProductProducer productProducer;

    public void sendMessage(ProductMessage message) throws Exception {
        log.info("[ProductService] send product to topic, message: " + message.toString());
        productProducer.send(message);
    }
}