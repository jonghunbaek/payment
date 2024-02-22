package com.example.payment.controller.dto;

import com.example.payment.domain.Order;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderResponse {

    private String orderId;
    private String pdName;
    private String amount;

    @Builder
    private OrderResponse(String orderId, String pdName, int amount) {
        this.orderId = orderId;
        this.pdName = pdName;
        this.amount = String.valueOf(amount);
    }

    public static OrderResponse of(Order order) {
        return OrderResponse.builder()
            .orderId(order.getId())
            .pdName(order.getProduct().getName())
            .amount(order.getAmount())
            .build();
    }
}
