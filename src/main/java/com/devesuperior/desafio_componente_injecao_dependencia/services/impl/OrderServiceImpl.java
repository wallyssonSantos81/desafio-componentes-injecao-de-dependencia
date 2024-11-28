package com.devesuperior.desafio_componente_injecao_dependencia.services.impl;

import com.devesuperior.desafio_componente_injecao_dependencia.model.Order;
import com.devesuperior.desafio_componente_injecao_dependencia.services.OrderService;
import com.devesuperior.desafio_componente_injecao_dependencia.services.ShippingService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    private final ShippingService shippingService;

    
    public OrderServiceImpl(ShippingService shippingService){
        this.shippingService = shippingService;
    }
    @Override
    public double total(Order order){
        double discountValue = order.getBasic() * (order.getDiscount()/100);
        double discountdPrice = order.getBasic() - discountValue;
        double shippingCost = shippingService.shipment(order);
        return discountdPrice + shippingCost;

    }
}
