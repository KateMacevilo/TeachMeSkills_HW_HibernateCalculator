package com.teachMeSkills.calculator.web.sevlet;

import com.teachMeSkills.calculator.entity.Operation;
import com.teachMeSkills.calculator.entity.User;
import com.teachMeSkills.calculator.service.OperationService;
import com.teachMeSkills.calculator.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "CalcServlet", urlPatterns = "/calculate")
public class CalcServlet extends HttpServlet {

    private final OperationService operationService = new OperationService();
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String operand = req.getParameter("operand");

        double result = operationService.getResult(num1, num2, operand);

        User user = (User) req.getSession().getAttribute("user");
        Operation operation = new Operation(num1, num2, operand, result);
        operation.setUser(user);
        operationService.save(operation);

        req.setAttribute("result", result);
        getServletContext().getRequestDispatcher("/calcPage.jsp").forward(req, resp);
    }

}
