package com.satish.projects.aopapp.service;

public interface ShipmentService {
        String orderPackage(Long orderId);

      void trackPackage(Long orderId);
}
