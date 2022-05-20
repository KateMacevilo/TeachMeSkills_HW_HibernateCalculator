package com.teachMeSkills.calculator.web.sevlet.user;

import com.teachMeSkills.calculator.entity.User;
import com.teachMeSkills.calculator.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);

        boolean isAdded = userService.saveUser(user);

        req.setAttribute("isAdded", isAdded);
        if (isAdded) {
            resp.sendRedirect("/authorization.jsp");
        } else {
            getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
            resp.setStatus(400);
        }

    }
}
