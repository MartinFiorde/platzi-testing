package com.platzi.payments.library_simulation;

public class PaymentResponse {

    public enum PaymentStatus {OK, ERROR}
    private PaymentStatus status;

    public PaymentResponse(PaymentStatus status) {
        this.status = status;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
