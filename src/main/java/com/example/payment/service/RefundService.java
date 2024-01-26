package com.example.payment.service;

import com.example.payment.controller.dto.PaymentResult;
import com.example.payment.service.dto.PaymentInfo;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;

@Transactional
@RequiredArgsConstructor
@Service
public class RefundService {

    private final IamportClient iamportClient;

    public PaymentResult refund(PaymentInfo paymentInfo) {
        BigDecimal amount = BigDecimal.valueOf(Long.valueOf(paymentInfo.getPaidAmount()));
        CancelData cancelData = new CancelData(paymentInfo.getImpUid(), true, amount);

        IamportResponse<Payment> cancelResult;
        try {
             cancelResult = iamportClient.cancelPaymentByImpUid(cancelData);
        } catch (IamportResponseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
