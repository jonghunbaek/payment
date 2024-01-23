package com.example.payment.controller;

import com.example.payment.controller.dto.PaymentResult;
import com.example.payment.service.PaymentService;
import com.example.payment.service.dto.PaymentInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/payment")
@RequiredArgsConstructor
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/validation")
    public PaymentResult validatePaymentInfo(@RequestBody PaymentInfo paymentInfo) {
        return paymentService.createPayment(paymentInfo);
    }
}
