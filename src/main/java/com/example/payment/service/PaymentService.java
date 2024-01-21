package com.example.payment.service;

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

    public void validate() throws IamportResponseException, IOException {
        IamportResponse<Payment> paymentIamportResponse = iamportClient.paymentByImpUid("23");
    }
}
