package com.example.payment.service;

import com.example.payment.controller.dto.OrderResponse;
import com.example.payment.domain.Order;
import com.example.payment.domain.Product;
import com.example.payment.repository.OrderRepository;
import com.example.payment.repository.ProductRepository;
import com.example.payment.service.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderResponse createOrder(OrderRequest orderRequest) {
        log.info("no :: {}", orderRequest.getPdNo());
        Product product = productRepository.findByNo(orderRequest.getPdNo())
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품 번호입니다." + orderRequest.getPdNo()));

        Order order = orderRepository.save(Order.builder()
            .product(product)
            .amount(product.getAmount())
            .build());

        return OrderResponse.of(order);
    }
}
