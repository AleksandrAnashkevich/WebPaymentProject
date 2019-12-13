package by.epam.webpayment.servlet;

import by.epam.webpayment.dao.DAOFactory;
import by.epam.webpayment.entity.Card;
import by.epam.webpayment.entity.User;
import by.epam.webpayment.util.Utils;
import by.epam.webpayment.validator.ValidatorCard;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addCard")
public class AddCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher=this.getServletContext()
                .getRequestDispatcher("/views/addCardView.jsp");
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=Utils.getLoginedUser(req.getSession());
        int id = user.getId();
        String number = req.getParameter("number");
        String cvv = req.getParameter("cvv");

        if (!ValidatorCard.numberValid(number)) {
            String message = "Invalid data";
            req.setAttribute("message", message);
            RequestDispatcher dispatcher = this.getServletContext()
                    .getRequestDispatcher("/views/addCardView");
            dispatcher.forward(req, resp);
        } else {

            DAOFactory.getInstance().getCardsDAO().insert(new Card(0, number, cvv, id));
            resp.sendRedirect(req.getContextPath() + "/cardList");
        }
    }

}
