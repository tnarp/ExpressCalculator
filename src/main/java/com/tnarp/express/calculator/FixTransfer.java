package com.tnarp.express.calculator;

import java.util.Stack;

public class FixTransfer {

    private OperatorUtil operatorUtil = new OperatorUtil();

    public String inFixToPostFix(String inFixExpress) {
        StringBuilder postFixExpressBuffer = new StringBuilder();
        Stack<String> operators = new Stack<>();
        for (char c : inFixExpress.toCharArray()) {
            String str = String.valueOf(c);
            if (isNumber(str)) {
                postFixExpressBuffer.append(str);
            } else {
                if (operatorUtil.isLeftParenthesis(str)) {
                    operators.push(str);
                }
                if (operatorUtil.isRightParenthesis(str)) {
                    postFixExpressBuffer.append(fetchOperatorInParenthesis(operators));
                }
                if (operatorUtil.isOperator(str)) {
                    postFixExpressBuffer.append(fetchHighOrEqualPriorityOperator(operators, str));
                    operators.push(str);
                }
            }
        }
        postFixExpressBuffer.append(fetchAllRemainOperator(operators));
        return postFixExpressBuffer.toString();
    }

    private boolean isNumber(String str) {
        return !(operatorUtil.isOperator(str) || operatorUtil.isParenthesis(str));
    }

    private String fetchHighOrEqualPriorityOperator(Stack<String> operators, String str) {
        StringBuilder allHighOrEqualPriorityOperator = new StringBuilder();
        while (!operators.isEmpty()) {
            if (operatorUtil.isHighOrEqualPriority(operators.peek(), str)) {
                allHighOrEqualPriorityOperator.append(operators.pop());
            } else {
                break;
            }
        }
        return allHighOrEqualPriorityOperator.toString();
    }

    private String fetchOperatorInParenthesis(Stack<String> operators) {
        StringBuilder operatorInParenthesis = new StringBuilder();
        while (!operatorUtil.isLeftParenthesis(operators.peek())) {
            operatorInParenthesis.append(operators.pop());
        }
        operators.pop();
        return operatorInParenthesis.toString();
    }

    private String fetchAllRemainOperator(Stack<String> operators) {
        StringBuilder allRemainOperator = new StringBuilder();
        while (!operators.isEmpty()) {
            allRemainOperator.append(operators.pop());
        }
        return allRemainOperator.toString();
    }
}
