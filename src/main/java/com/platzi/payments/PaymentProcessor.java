package com.platzi.payments;

import com.platzi.payments.library_simulation.PaymentRequest;
import com.platzi.payments.library_simulation.PaymentResponse;

public class PaymentProcessor {

    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount) {
        PaymentResponse response = paymentGateway.requestPayment(new PaymentRequest(1000));
        return response.getStatus() == PaymentResponse.PaymentStatus.OK;
    }
}
