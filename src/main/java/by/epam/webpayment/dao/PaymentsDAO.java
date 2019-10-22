package by.epam.webpayment.dao;

import by.epam.webpayment.entity.Payment;

import java.util.List;

public interface PaymentsDAO {
    List<Payment> findPayments ();
}
