package com.example.payment.service.dto;

import lombok.Getter;

@Getter
public class PaymentInfo {

    private String impUid;
    private String merchantUid;
    private String paidAmount;
}
