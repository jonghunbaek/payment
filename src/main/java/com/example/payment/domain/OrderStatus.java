package com.example.payment.domain;

public enum OrderStatus {

    COMPLETE("완료"),
    WAITING_PAY("결제 대기"),
    CANCEL("주문 취소")
    ;


    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }
}
