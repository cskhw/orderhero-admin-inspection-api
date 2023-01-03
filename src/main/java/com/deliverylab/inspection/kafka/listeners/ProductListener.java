package com.deliverylab.inspection.kafka.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.deliverylab.inspection.payload.request.ProductMessage;

@Slf4j
@Service
public class ProductListener {
    @KafkaListener(topics = "product", containerFactory = "productKafkaListenerContainerFactory")
    public void newProductListener(ProductMessage product) {
        log.info("Get request from Front 'save product'" + product.toString());
    }
}