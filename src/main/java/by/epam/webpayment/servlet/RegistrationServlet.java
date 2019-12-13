package by.epam.webpayment.servlet;

import by.epam.webpayment.dao.DAOFactory;
import by.epam.webpayment.entity.User;
import by.epam.webpayment.util.Utils;
import by.epam.webpayment.validator.ValidatorUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req
                .getRequestDispatcher("views/registrationView.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("secondName");
        String secondName = req.getParameter("firstName");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordRepeat = req.getParameter("passwordRepeat");

        User user = new User(firstName, secondName, login, email, password);

        if (!(ValidatorUser.validator(user) && password.equals(passwordRepeat))) {
            String message = "Invalid data";
            req.setAttribute("message", message);
            RequestDispatcher dispatcher = this.getServletContext()
                    .getRequestDispatcher("/views/registrationView.jsp");
            dispatcher.forward(req, resp);
        } else {
            DAOFactory.getInstance().getUserDAO().insert(user);;

            HttpSession session=req.getSession();
            Utils.storeLoginedUser(session, user);

            resp.sendRedirect(req.getContextPath() + "/userInfo");

        }

    }
}
