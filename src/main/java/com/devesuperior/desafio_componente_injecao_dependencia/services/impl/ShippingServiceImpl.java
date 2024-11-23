package com.devesuperior.desafio_componente_injecao_dependencia.services.impl;

import com.devesuperior.desafio_componente_injecao_dependencia.model.Order;
import com.devesuperior.desafio_componente_injecao_dependencia.services.ShippingService;
import org.springframework.stereotype.Service;

@Service
public class ShippingServiceImpl implements ShippingService {

    @Override
    public double shipment(Order order){

        if(order.getBasic()<100.0){
            return 20.0;
        }else if(order.getBasic()<200){
            return 12.0;
        }else{
            return 0.0;
        }
    }


}
