package com.tnarp.express.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)
public class FixCalculatorTest {

    private String postFixExpress;
    private double valueExpected;

    @Parameters
    public static Iterable<Object[]> prepareTestData() {
        return Arrays.asList(new Object[][]{
                {"12*3+", 5.0d},
                {"12+3*4*", 36.0d},
        });
    }

    public FixCalculatorTest(String postFixExpress, double valueExpected) {
        this.postFixExpress = postFixExpress;
        this.valueExpected = valueExpected;
    }

    @Test
    public void test_calculate_post_fix_express() {
        FixCalculator postFixCalculator = new FixCalculator();

        double valueActual = postFixCalculator.calculatePostFix(postFixExpress);

        assertThat(valueActual, is(valueExpected));
    }
}