package com.satish.projects.aopapp;

import com.satish.projects.aopapp.service.ShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class AopAppApplicationTests {

    @Autowired
    private ShipmentService shipmentService;

    @Test
    void contextLoads() {
    }

    @Test
    void orderPackage() {
        String orderString = shipmentService.orderPackage(-1L);
        log.info(orderString);
    }

    @Test
    void trackPackage() {
        shipmentService.trackPackage(1L);
    }

}
