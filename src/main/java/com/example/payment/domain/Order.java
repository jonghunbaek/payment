package com.example.payment.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Table(name = "orders")
@Entity
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int amount;
    @OneToOne
    private Product product;

    @Builder
    private Order(int amount, Product product) {
        this.amount = amount;
        this.product = product;
    }
}
