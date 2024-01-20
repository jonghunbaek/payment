package com.example.payment.service;

import com.example.payment.controller.dto.ProductResponse;
import com.example.payment.domain.Product;
import com.example.payment.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponse> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
            .map(ProductResponse::of)
            .toList();
    }

}
