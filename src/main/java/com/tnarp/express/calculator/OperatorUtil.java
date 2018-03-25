package com.tnarp.express.calculator;

import java.util.HashMap;
import java.util.Map;

public class OperatorUtil {

    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";
    private Map<String, Integer> allOperatorPriority = new HashMap<>();

    public OperatorUtil() {
        this.allOperatorPriority.put("+", 0);
        this.allOperatorPriority.put("-", 0);
        this.allOperatorPriority.put("*", 1);
        this.allOperatorPriority.put("/", 1);
    }

    public boolean isOperator(String str) {
        return allOperatorPriority.keySet().contains(str);
    }

    public boolean isParenthesis(String str) {
        return str.equals(LEFT_PARENTHESIS) || str.equals(RIGHT_PARENTHESIS);
    }

    public boolean isRightParenthesis(String str) {
        return str.equals(RIGHT_PARENTHESIS);
    }

    public boolean isLeftParenthesis(String str) {
        return str.equals(LEFT_PARENTHESIS);
    }

    public boolean isHighPriority(String operator1, String operator2) {
        if (isParenthesis(operator1) || isParenthesis(operator2)) {
            return false;
        }
        return allOperatorPriority.get(operator1) > allOperatorPriority.get(operator2);
    }
}
