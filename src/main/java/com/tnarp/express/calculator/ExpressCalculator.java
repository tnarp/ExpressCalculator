package com.tnarp.express.calculator;

public class ExpressCalculator {

    public double calculate(String express) {
        String postFixExpress = new FixTransfer().inFixToPostFix(express);
        return new FixCalculator().calculatePostFix(postFixExpress);
    }
}
