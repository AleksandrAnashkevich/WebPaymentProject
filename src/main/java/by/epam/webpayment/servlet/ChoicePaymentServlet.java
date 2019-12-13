package by.epam.webpayment.servlet;

import by.epam.webpayment.dao.DAOFactory;
import by.epam.webpayment.entity.Payment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/choicePayment")
public class ChoicePaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id = Integer.parseInt(req.getParameter("id"));
            Payment payment= DAOFactory.getInstance().getPaymentDAO().findById(id);

            if (payment == null){
                RequestDispatcher dispatcher=this.getServletContext()
                        .getRequestDispatcher("/views/choicePaymentListView.jsp");
                dispatcher.forward(req,resp);
            } else {
                req.getSession().setAttribute("choicePayment",payment);
                resp.sendRedirect(req.getContextPath()+"/pay");
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
