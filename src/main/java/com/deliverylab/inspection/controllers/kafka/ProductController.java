package com.deliverylab.inspection.controllers.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.deliverylab.inspection.payload.request.Product;
import com.deliverylab.inspection.payload.request.ProductMessage;
import com.deliverylab.inspection.services.ProductService;

@Slf4j
@Service
@RestController
@RequestMapping("/kafka/log")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/name")
    public String sayHello() {
        return String.format("Hello World!!!");
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product) throws Exception {
        log.info("[DemoController]: add new product = " + product.toString());
        productService.sendMessage(new ProductMessage(product, "add"));
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable String id) throws Exception {
        log.info("[DemoController]: delete product id = " + id);
        Product p = new Product();
        p.setId(id);
        productService.sendMessage(new ProductMessage(p, "delete"));
    }
}