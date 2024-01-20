package com.example.payment.controller.dto;

import com.example.payment.domain.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductResponse {

    private String no;
    private String name;
    private int amount;

    @Builder
    private ProductResponse(String no, String name, int amount) {
        this.no = no;
        this.name = name;
        this.amount = amount;
    }

    public static ProductResponse of(Product product) {
        return ProductResponse.builder()
            .no(product.getNo())
            .name(product.getName())
            .amount(product.getAmount())
            .build();
    }
}
