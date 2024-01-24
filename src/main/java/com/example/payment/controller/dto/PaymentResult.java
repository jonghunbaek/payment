package com.example.payment.controller.dto;

import com.siot.IamportRestClient.response.Payment;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PaymentResult {

    String imp_uid;
    String merchant_uid;
    String name;
    BigDecimal amount;
    String status;

    @Builder
    private PaymentResult(String imp_uid, String merchant_uid, String name, BigDecimal amount, String status) {
        this.imp_uid = imp_uid;
        this.merchant_uid = merchant_uid;
        this.name = name;
        this.amount = amount;
        this.status = status;
    }

    public static PaymentResult of(Payment payment) {
        return PaymentResult.builder()
            .imp_uid(payment.getImpUid())
            .merchant_uid(payment.getMerchantUid())
            .name(payment.getName())
            .amount(payment.getAmount())
            .status(payment.getStatus())
            .build();
    }
}
