package com.example.payment.service;

import com.example.payment.controller.dto.OrderResponse;
import com.example.payment.domain.Order;
import com.example.payment.domain.OrderStatus;
import com.example.payment.domain.Product;
import com.example.payment.repository.OrderRepository;
import com.example.payment.repository.ProductRepository;
import com.example.payment.service.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderResponse createOrder(OrderRequest orderRequest) {
        log.info("no :: {}", orderRequest.getPdNo());
        Product product = productRepository.findByNo(orderRequest.getPdNo())
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품 번호입니다. productNo :: " + orderRequest.getPdNo()));

        Order order = orderRepository.save(Order.builder()
            .id(UUID.randomUUID().toString())
            .amount(product.getAmount())
            .status(OrderStatus.WAITING_PAY)
            .product(product)
            .build());

        return OrderResponse.of(order);
    }

    public void completeOrder(String orderId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 주문 번호입니다. orderId :: " + orderId));

        order.complete();
    }

    public void deleteOrder(String orderId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 주문 번호입니다. orderId :: " + orderId));

        order.delete();
    }
}
