package by.epam.webpayment.dao;

import by.epam.webpayment.entity.Operation;

import java.util.List;

public interface OperationsDAO {
    void insert(int idUser, int idPayment, String type);

    List<Operation> findAll (int idUser);
}
