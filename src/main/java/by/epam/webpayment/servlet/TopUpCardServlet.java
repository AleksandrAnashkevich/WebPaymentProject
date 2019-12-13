package by.epam.webpayment.servlet;

import by.epam.webpayment.dao.DAOFactory;
import by.epam.webpayment.entity.Card;
import by.epam.webpayment.entity.User;
import by.epam.webpayment.validator.ValidatorCard;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/topUpCard")
public class TopUpCardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Card card = DAOFactory.getInstance().getCardsDAO().findById(id);

        if (card == null) {
            resp.sendRedirect(req.getServletPath() + "/cardList");
            return;
        }

        req.setAttribute("card", card);

        RequestDispatcher dispatcher = this.getServletContext()
                .getRequestDispatcher("/views/topUpCardView.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String depositStr = req.getParameter("deposit");
        int id = Integer.parseInt(req.getParameter("id"));
        Card card = DAOFactory.getInstance().getCardsDAO().findById(id);

        if (!ValidatorCard.depositValid(depositStr)) {
            String message = "Invalid data";
            req.setAttribute("message", message);
            RequestDispatcher dispatcher = this.getServletContext()
                    .getRequestDispatcher("/views/topUpCardView");
            dispatcher.forward(req, resp);
        } else {
            double deposit = Double.parseDouble(depositStr);
            card.setDeposit(card.getDeposit() + deposit);
            DAOFactory.getInstance().getCardsDAO().update(card);
            resp.sendRedirect(req.getContextPath() + "/cardList");
        }
    }
}
