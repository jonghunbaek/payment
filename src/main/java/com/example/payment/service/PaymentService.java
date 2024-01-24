package com.example.payment.service;

import com.example.payment.controller.dto.PaymentResult;
import com.example.payment.service.dto.PaymentInfo;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Transactional
@RequiredArgsConstructor
@Service
public class PaymentService {

    private final IamportClient iamportClient;

    public PaymentResult createPayment(PaymentInfo paymentInfo) {
        IamportResponse<Payment> impResponse;

        try {
            impResponse = iamportClient.paymentByImpUid(paymentInfo.getImpUid());
        } catch (IamportResponseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        validateAmount(paymentInfo, impResponse);

        return PaymentResult.of(impResponse.getResponse());
    }

    private void validateAmount(PaymentInfo paymentInfo, IamportResponse<Payment> impResponse) {
        if (!impResponse.getResponse().getAmount().toString().equals(paymentInfo.getPaidAmount())) {
            throw new IllegalStateException("결제 금액이 일치하지 않습니다. realAmount, requestAmount :: "
                + impResponse.getResponse().getAmount() + ", " + paymentInfo.getPaidAmount());
        }
    }
}
