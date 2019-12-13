package by.epam.webpayment.dao;

import by.epam.webpayment.dao.impl.CardsDAOImpl;
import by.epam.webpayment.dao.impl.PaymentDAOImpl;
import by.epam.webpayment.dao.impl.RolesDAOImpl;
import by.epam.webpayment.dao.impl.UsersDAOImpl;

public class DAOFactory {
    private static DAOFactory ourInstance = new DAOFactory();

    private final UserDAO  userDAO= new UsersDAOImpl();
    private final PaymentDAO paymentDAO = new PaymentDAOImpl();
    private final RolesDAO rolesDAO = new RolesDAOImpl();
    private final CardsDAO cardsDAO = new CardsDAOImpl();


    private DAOFactory() {
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public PaymentDAO getPaymentDAO() {
        return paymentDAO;
    }

    public RolesDAO getRolesDAO() {
        return rolesDAO;
    }

    public CardsDAO getCardsDAO() {
        return cardsDAO;
    }

    public static DAOFactory getInstance() {
        return ourInstance;
    }

}
