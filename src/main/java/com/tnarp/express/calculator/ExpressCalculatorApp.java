package com.tnarp.express.calculator;

public class ExpressCalculatorApp {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please input an express!");
            return;
        }
        String express = args[0];
        double value = new ExpressCalculator().calculate(express);
        System.out.println(express + " value is " + value);
    }
}
