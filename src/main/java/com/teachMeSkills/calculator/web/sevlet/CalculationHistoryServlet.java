package com.teachMeSkills.calculator.web.sevlet;

import com.teachMeSkills.calculator.entity.Operation;
import com.teachMeSkills.calculator.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CalculationHistory", urlPatterns = "/calculationHistory")
public class CalculationHistoryServlet extends HttpServlet {

    private final OperationService operationService = new OperationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Operation> historyList = operationService.getAllOperations();
        req.setAttribute("historyList", historyList);
        getServletContext().getRequestDispatcher("/calcPage.jsp").forward(req, resp);

    }
}
