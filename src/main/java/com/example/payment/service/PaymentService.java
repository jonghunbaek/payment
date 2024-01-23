package com.example.payment.service;

import com.example.payment.controller.dto.PaymentResult;
import com.example.payment.service.dto.PaymentInfo;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class PaymentService {

    private final IamportClient iamportClient;

    public PaymentResult createPayment(PaymentInfo paymentInfo) {
        try {
            IamportResponse<Payment> impResponse = iamportClient.paymentByImpUid(paymentInfo.getImpUid());
            boolean isSameAmount = impResponse.getResponse().getAmount().toString().equals(paymentInfo.getPaidAmount());

            if (isSameAmount) {
                return null;
            }

            // 환불 로직
        } catch (IamportResponseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
