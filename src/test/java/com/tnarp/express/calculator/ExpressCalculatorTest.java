package com.tnarp.express.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)
public class ExpressCalculatorTest {
    private String express;
    private double valueExpected;

    @Parameters
    public static Iterable<Object[]> prepareTestData() {
        return Arrays.asList(new Object[][]{
                {"1+2", 3.0d},
                {"3-(2+1)", 0.0d},
                {"4-(3-1)", 2.0d},
                {"1+2*3", 7.0d},
                {"4/2*2", 4.0d},
                {"(1+2)*2+4", 10.0d},
        });
    }

    public ExpressCalculatorTest(String express, double valueExpected) {
        this.express = express;
        this.valueExpected = valueExpected;
    }

    @Test
    public void test_calculate_post_fix_express() {
        ExpressCalculator expressCalculator = new ExpressCalculator();

        double valueActual = expressCalculator.calculate(express);

        assertThat(valueActual, is(valueExpected));
    }
}