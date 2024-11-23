package com.devesuperior.desafio_componente_injecao_dependencia.controller;


import com.devesuperior.desafio_componente_injecao_dependencia.model.Order;
import com.devesuperior.desafio_componente_injecao_dependencia.services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }
    @GetMapping("/order")
    public String calculateOrder(
            @RequestParam Integer code,
            @RequestParam Double basic,
            @RequestParam Double discount) {

        Order order = new Order(code, basic, discount);
        double total = orderService.total(order);

        return String.format("Pedido código: %d\nValor total: R$ %.2f", order.getCode(), total);

    }
}
