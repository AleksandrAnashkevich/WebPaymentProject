package by.epam.webpayment.servlet;

import by.epam.webpayment.dao.DAOFactory;
import by.epam.webpayment.entity.Card;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/choiceCard")
public class ChoiceCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Card card = DAOFactory.getInstance().getCardsDAO().findById(id);

        if (card == null) {
            RequestDispatcher dispatcher = this.getServletContext()
                    .getRequestDispatcher("/views/choiceCardListView.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.getSession().setAttribute("choiceCard", card);
            resp.sendRedirect(req.getContextPath() + "/pay");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
