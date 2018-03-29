package com.tnarp.express.calculator;

import java.util.Stack;

public class FixCalculator {

    private static final String ZERO = "0";
    private OperatorUtil operatorUtil = new OperatorUtil();

    public double calculatePostFix(String postFixExpress) {
        Stack<String> numbers = new Stack<>();
        for (char c : postFixExpress.toCharArray()) {
            String str = String.valueOf(c);
            if (operatorUtil.isOperator(str)) {
                String number2 = numbers.pop();
                String number1 = numbers.pop();
                String value = calculate(number1, number2, str);
                numbers.push(value);
            } else {
                numbers.push(str);
            }
        }
        return Double.valueOf(numbers.pop());
    }

    private String calculate(String number1, String number2, String str) {
        double value = 0;
        switch (str) {
            case "+":
                value = Double.valueOf(number1) + Double.valueOf(number2);
                break;
            case "-":
                value = Double.valueOf(number1) - Double.valueOf(number2);
                break;
            case "*":
                value = Double.valueOf(number1) * Double.valueOf(number2);
                break;
            case "/":
                if (number2.equals(ZERO)) {
                    throw new ArithmeticException("/ by zero");
                }
                value = Double.valueOf(number1) / Double.valueOf(number2);
                break;
            default:
                break;
        }
        return String.valueOf(value);
    }
}
