package by.epam.webpayment.servlet;

import by.epam.webpayment.dao.DAOFactory;
import by.epam.webpayment.entity.Card;
import by.epam.webpayment.entity.User;
import by.epam.webpayment.util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/cardList")
public class CardListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=Utils.getLoginedUser(req.getSession());

        List<Card> cardList= DAOFactory.getInstance().getCardsDAO().findAll(user.getId());

        req.setAttribute("cardList",cardList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/cardListView.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
