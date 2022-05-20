package com.teachMeSkills.calculator.entity;

import javax.persistence.*;

@Entity
@Table(name = "operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double num1;
    private double num2;
    private String operand;
    private double result;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Operation(double num1, double num2, String operand, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.operand = operand;
        this.result = result;
    }

    public Operation() {
    }

    public int getId() {
        return id;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public String getOperand() {
        return operand;
    }

    public double getResult() {
        return result;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return System.lineSeparator() +
                getUser().getLogin() +": "+
                System.lineSeparator() +
                num1 + " " + operandSymbol(this.operand) + " " + num2 + " = " + result;
    }


    private String operandSymbol(String operand) {
        switch (operand) {
            case "sum":
                return "+";
            case "diff":
                return "-";
            case "mult":
                return "*";
            case "div":
                return "/";
        }
        return "no result";
    }

}
