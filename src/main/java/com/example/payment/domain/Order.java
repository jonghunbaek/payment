package com.example.payment.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.example.payment.domain.OrderStatus.*;

@NoArgsConstructor
@Getter
@Table(name = "orders")
@Entity
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int amount;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToOne
    private Product product;

    @Builder
    private Order(int amount, OrderStatus status, Product product) {
        this.amount = amount;
        this.status = status;
        this.product = product;
    }

    public void delete() {
        this.status = CANCEL;
    }

    public void complete() {
        this.status = COMPLETE;
    }
}
