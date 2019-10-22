package by.epam.webpayment.dao;

import by.epam.webpayment.dao.impl.PaymentsDAOImpl;
import by.epam.webpayment.dao.impl.RolesDAOImpl;
import by.epam.webpayment.dao.impl.UsersDAOImpl;

public class DAOFactory {
    private static DAOFactory ourInstance = new DAOFactory();

    private final UserDAO  userDAO= new UsersDAOImpl();
    private final PaymentsDAO paymentsDAO = new PaymentsDAOImpl();
    private final RolesDAO rolesDAO = new RolesDAOImpl();

    private DAOFactory() {
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public PaymentsDAO getPaymentsDAO() {
        return paymentsDAO;
    }

    public RolesDAO getRolesDAO() {
        return rolesDAO;
    }

    public static DAOFactory getInstance() {
        return ourInstance;
    }

}
