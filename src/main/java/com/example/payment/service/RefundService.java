package com.example.payment.service;

import com.example.payment.controller.dto.PaymentResult;
import com.siot.IamportRestClient.IamportClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class RefundService {

    private final IamportClient iamportClient;

    public PaymentResult refund() {
        return null;
    }
}
