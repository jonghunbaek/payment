package com.example.payment.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PaymentInfo {

    private String impUid;
    private String merchantUid;
    private String paidAmount;
}
