package com.tnarp.express.calculator;

public class ExpressCalculator {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please input an express!");
            return;
        }
        String inFixExpress = args[0];
        String postFixExpress = new FixTransfer().inFixToPostFix(inFixExpress);
        double value = new FixCalculator().calculatePostFix(postFixExpress);
        System.out.println(inFixExpress + " value is " + value);
    }
}
