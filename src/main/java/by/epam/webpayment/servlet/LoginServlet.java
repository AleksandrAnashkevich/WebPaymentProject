package by.epam.webpayment.servlet;

import by.epam.webpayment.dao.DAOFactory;
import by.epam.webpayment.entity.User;
import by.epam.webpayment.util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/loginView.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String rememberMeStr = req.getParameter("rememberMe");
        boolean remember = "Y".equals(rememberMeStr);
        String message;

        Connection conn= Utils.getStoredConnection(req);
        User user = DAOFactory.getInstance().getUserDAO().findByLogin(login);

        if ((user != null) && (user.getPassword().equals(password))) {
            HttpSession session=req.getSession();
            Utils.storeLoginedUser(session, user);

            if (remember) {
                Utils.storeUserCookie(resp, user);
            }
            else {
                Utils.deleteUserCookie(resp);
            }


            resp.sendRedirect(req.getContextPath() + "/userInfo");
        }
        else {
            message = "Not successful. Incorrect data";
            req.setAttribute("message", message);
            doGet(req,resp);
        }

    }


}
