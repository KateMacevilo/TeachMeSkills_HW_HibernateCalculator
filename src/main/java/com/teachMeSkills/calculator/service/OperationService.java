package com.teachMeSkills.calculator.service;

import com.teachMeSkills.calculator.dao.OperationDAO;
import com.teachMeSkills.calculator.entity.Operation;
import com.teachMeSkills.calculator.storage.OperationStorage;

import java.util.List;

public class OperationService {

    private OperationDAO operationDAO = new OperationDAO();

    public boolean save(Operation operation) {
        operationDAO.save(operation);
        return true;
    }

    public List<Operation> getAllOperationsByUserId(int id) {
        return operationDAO.getAllOperationsByUserId(id);
    }

    public double getResult(double num1, double num2, String operand) {
        return operationDAO.getResult(num1, num2, operand);
    }

    public List<Operation> getAllOperations(){
        return operationDAO.getAllOperations();
    }


}
