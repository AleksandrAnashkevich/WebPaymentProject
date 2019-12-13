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

@WebServlet(urlPatterns = "/deleteCard")
public class DeleteCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Card card= DAOFactory.getInstance().getCardsDAO().findById(id);

        if (card == null){
            RequestDispatcher dispatcher=this.getServletContext()
                    .getRequestDispatcher("/views/deleteCardView.jsp");
            dispatcher.forward(req,resp);
        } else {
            DAOFactory.getInstance().getCardsDAO().delete(card);
            resp.sendRedirect(req.getContextPath()+"/cardList");
        }
        ;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
