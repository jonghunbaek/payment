package com.example.payment.controller;

import com.example.payment.controller.dto.OrderResponse;
import com.example.payment.service.OrderService;
import com.example.payment.service.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public OrderResponse order(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }
}
