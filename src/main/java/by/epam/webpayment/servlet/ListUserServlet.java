package by.epam.webpayment.servlet;

import by.epam.webpayment.dao.DAOFactory;
import by.epam.webpayment.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users=DAOFactory.getInstance().getUserDAO().findAll();
        List<String> strings =new ArrayList<String>();
        for (User user:users){
            strings.add(user.toString());
        }
        req.setAttribute("userNames", strings);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
