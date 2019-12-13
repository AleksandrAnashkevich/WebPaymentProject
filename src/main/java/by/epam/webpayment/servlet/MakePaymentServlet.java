package by.epam.webpayment.servlet;

import by.epam.webpayment.dao.DAOFactory;
import by.epam.webpayment.entity.Card;
import by.epam.webpayment.entity.Payment;
import by.epam.webpayment.entity.User;
import by.epam.webpayment.util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/makePayment")
public class MakePaymentServlet extends HttpServlet {
    private static String successfully="successfully";
    private static String notSuccessfully="notSuccessfully";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user= Utils.getLoginedUser(req.getSession());
        Payment payment=(Payment) req.getSession().getAttribute("choicePayment");
        Card card = (Card) req.getSession().getAttribute("choiceCard");

        String message;
        if (card.getDeposit()>=payment.getAmount()){
            card.setDeposit(card.getDeposit()-payment.getAmount());
            DAOFactory.getInstance().getCardsDAO().update(card);
            message=successfully;
        }   else {
            message=notSuccessfully;
        }
        req.setAttribute("message",message);
        req.getSession().removeAttribute("choicePayment");
        req.getSession().removeAttribute("choiceCard");

        RequestDispatcher dispatcher = this.getServletContext()
                .getRequestDispatcher("/views/payView.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
