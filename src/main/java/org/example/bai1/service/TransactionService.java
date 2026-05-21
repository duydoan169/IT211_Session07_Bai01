package org.example.bai1.service;

import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    public boolean processPayment(String accountNumber, double amount) {
        System.out.println("SERVICE: Dang xu ly thanh toan cho tai khoan " + accountNumber);
        try { Thread.sleep(150); } catch (InterruptedException e) {}
        return true;
    }
}
