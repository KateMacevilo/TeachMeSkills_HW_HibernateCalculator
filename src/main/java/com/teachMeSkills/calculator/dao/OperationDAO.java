package com.teachMeSkills.calculator.dao;

import com.teachMeSkills.calculator.config.HibernateSessionFactoryUtil;
import com.teachMeSkills.calculator.entity.Operation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OperationDAO {

    public void save(Operation operation) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(operation);
        tx1.commit();
        session.close();
    }

    public List<Operation> getAllOperations(){
        List<Operation> operationList = (List<Operation>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Operation").list();
        return operationList;
    }

    public List<Operation> getAllOperationsByUserId(int user_id){
        List<Operation> operationList = (List<Operation>) HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Operation.class, user_id);
        return operationList;
    }

    public double getResult(double num1, double num2, String operand) {

        switch (operand) {
            case "sum":
                return num1 + num2;
            case "diff":
                return num1 - num2;
            case "mult":
                return  num1 * num2;
            case "div":
                return  num1 / num2;
        }
        return 0;
    }

}
