package com.example.payment.controller;

import com.example.payment.controller.dto.PaymentResult;
import com.example.payment.service.OrderService;
import com.example.payment.service.PaymentService;
import com.example.payment.service.RefundService;
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

    private final OrderService orderService;
    private final PaymentService paymentService;
    private final RefundService refundService;

    @PostMapping("/validation")
    public PaymentResult validatePaymentInfo(@RequestBody PaymentInfo paymentInfo) {
        long orderId = Long.parseLong(paymentInfo.getMerchantUid());

        try {
            PaymentResult result = paymentService.createPayment(paymentInfo);
            orderService.completeOrder(orderId);

            return result;
        } catch (IllegalStateException e) {
            orderService.deleteOrder(orderId);
            return refundService.refund();
        }
    }
}
