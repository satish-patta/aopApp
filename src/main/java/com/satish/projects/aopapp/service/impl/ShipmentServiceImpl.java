package com.satish.projects.aopapp.service.impl;

import com.satish.projects.aopapp.aspect.MyLogging;
import com.satish.projects.aopapp.service.ShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ShipmentServiceImpl implements ShipmentService {
    @Override
    @MyLogging
    public String orderPackage(Long orderId) {


        try{
            log.info("processing the order.....");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Error occurred while processing the order",e);
        }

        return "Order is processed successfully, orderId" + orderId;
    }

    @Override
    @Transactional
    public void trackPackage(Long orderId)  {
        try{
            log.info("Tacking the order.....");
            Thread.sleep(1000);


            throw new RuntimeException("Error occurred while processing the package.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}