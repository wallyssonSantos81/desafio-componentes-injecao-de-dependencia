package com.devesuperior.desafio_componente_injecao_dependencia.services;


import com.devesuperior.desafio_componente_injecao_dependencia.model.Order;
import org.springframework.stereotype.Service;

@Service
public interface ShippingService {

    double shipment(Order order);

}
