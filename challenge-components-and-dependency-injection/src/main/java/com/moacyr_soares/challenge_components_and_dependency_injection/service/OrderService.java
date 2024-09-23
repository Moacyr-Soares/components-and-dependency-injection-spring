package com.moacyr_soares.challenge_components_and_dependency_injection.service;

import com.moacyr_soares.challenge_components_and_dependency_injection.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;
    public double total(Order order){

        order.setBasic(order.getBasic() - (order.getBasic() * order.getDiscount() / 100));
        return order.getBasic() + shippingService.shipment(order);
    }
}
