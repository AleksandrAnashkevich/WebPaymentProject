package by.epam.webpayment.dao.impl;

import by.epam.webpayment.dao.OperationsDAO;
import by.epam.webpayment.entity.Operation;

import java.util.List;

public class OperationDAOImpl implements OperationsDAO {
    @Override
    public List<Operation> findAll(int idUser) {
        return null;
    }

    @Override
    public void insert(int idUser, int idPayment, String type) {

    }
}
