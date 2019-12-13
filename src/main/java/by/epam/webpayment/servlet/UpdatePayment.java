package by.epam.webpayment.servlet;

import by.epam.webpayment.dao.DAOFactory;
import by.epam.webpayment.entity.Payment;
import by.epam.webpayment.validator.ValidatorPayment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updatePayment")
public class UpdatePayment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Payment payment = DAOFactory.getInstance().getPaymentDAO().findById(id);

        if (payment == null) {
            resp.sendRedirect(req.getServletPath() + "/productList");
            return;
        }

        req.setAttribute("payment", payment);

        RequestDispatcher dispatcher = this.getServletContext()
                .getRequestDispatcher("/views/updatePaymentView.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String number = req.getParameter("number");
        String amountStr = req.getParameter("amount");
        int id = Integer.parseInt(req.getParameter("id"));

        if (!ValidatorPayment.validator(amountStr)) {
            String message = "Invalid data";
            req.setAttribute("message", message);
            RequestDispatcher dispatcher = this.getServletContext()
                    .getRequestDispatcher("/views/updatePaymentView.jsp");
            dispatcher.forward(req, resp);
        } else {
            double amount = Double.parseDouble(amountStr);
            DAOFactory.getInstance().getPaymentDAO().update(new Payment(id, amount, number, name));
            resp.sendRedirect(req.getContextPath() + "/paymentList");
        }
    }
}
