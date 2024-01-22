package com.example.payment.controller;

import com.example.payment.controller.dto.ProductResponse;
import com.example.payment.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;
    @Value("${imp.code}")
    private String impCode;

    @GetMapping("/products")
    public String findAll(Model model) {
        List<ProductResponse> products = productService.findAllProducts();

        model.addAttribute("products", products);
        model.addAttribute("impCode", impCode);

        return "product";
    }
}
