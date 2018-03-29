package com.tnarp.express.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)
public class FixTransferTest {

    private String inFixExpress;
    private String postFixExpressExpected;

    @Parameters
    public static Iterable<String[]> prepareExpress() {
        return Arrays.asList(new String[][]{
                {"1+2", "12+"},
                {"1+2-3", "12+3-"},
                {"1+2*3", "123*+"},
                {"1*2+3", "12*3+"},
                {"(1+2)*3", "12+3*"},
                {"((1+2)+3)*4", "12+3+4*"},
                {"(1+2)*3+4", "12+3*4+"},
                {"3-(2+1)", "321+-"},
                {"4/2*2", "42/2*"},
        });
    }

    public FixTransferTest(String inFixExpress, String postFixExpress) {
        this.inFixExpress = inFixExpress;
        this.postFixExpressExpected = postFixExpress;
    }

    @Test
    public void  test_in_fix_express_to_post_fix_express() {
        FixTransfer fixTransfer = new FixTransfer();

        String postFixExpressActual = fixTransfer.inFixToPostFix(inFixExpress);

        assertThat(postFixExpressActual, is(postFixExpressExpected));
    }
}
