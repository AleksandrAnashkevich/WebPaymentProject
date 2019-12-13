package by.epam.webpayment.servlet;

import by.epam.webpayment.dao.DAOFactory;
import by.epam.webpayment.entity.Payment;
import by.epam.webpayment.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/paymentList" })
public class PaymentListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Payment> payments=DAOFactory.getInstance().getPaymentDAO().findPayments();

        req.setAttribute("paymentList", payments);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/paymentListView.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer idPayment=new Integer(req.getParameter("id"));
        Payment infoPayment = DAOFactory.getInstance().getPaymentDAO().findById(idPayment);
        req.getSession().setAttribute("payment", infoPayment);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/paymentInfo.jsp");
        requestDispatcher.forward(req, resp);
    }
}
