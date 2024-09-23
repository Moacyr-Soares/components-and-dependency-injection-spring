package com.moacyr_soares.challenge_components_and_dependency_injection.service;

import com.moacyr_soares.challenge_components_and_dependency_injection.model.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order){

        if(order.getBasic() < 100.0 ){
            return 20.0;
        } else if (order.getBasic() >= 100.0 && order.getBasic() < 200.0) {
            return  12.0;
        } else {
            return 0.0;
        }
    }
}
