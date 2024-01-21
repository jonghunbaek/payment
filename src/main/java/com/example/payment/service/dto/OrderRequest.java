package com.example.payment.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderRequest {

    private String pdNo;
    private String pdName;
    private int pdAmount;
}
