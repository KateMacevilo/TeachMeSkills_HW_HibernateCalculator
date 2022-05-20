package com.teachMeSkills.calculator.web.sevlet.user;

import com.teachMeSkills.calculator.entity.User;
import com.teachMeSkills.calculator.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/authorization", name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userService.findByLogin(login);

        if (user.getLogin() != null) {
            boolean result = user.getPassword().equals(password);
            if (result) {
                req.getSession().setAttribute("user", user);

                req.setAttribute("isAdded", result);
                getServletContext().getRequestDispatcher("/calcPage.jsp").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
                resp.setStatus(401);
            }
        } else {
            resp.setStatus(401);
        }

    }
}
