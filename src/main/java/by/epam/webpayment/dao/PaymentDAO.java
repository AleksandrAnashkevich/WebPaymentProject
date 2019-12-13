package by.epam.webpayment.dao;

import by.epam.webpayment.entity.Payment;

import java.util.List;

public interface PaymentDAO {
    List<Payment> findPayments ();

    Payment findById (int id);

    void insert(Payment payment);

    void delete(Payment payment);

    void update(Payment payment);
}
