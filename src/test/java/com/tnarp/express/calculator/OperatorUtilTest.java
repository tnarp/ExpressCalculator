package com.tnarp.express.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class OperatorUtilTest {

    private OperatorUtil operatorUtil = new OperatorUtil();

    @Test
    public void testIsOperator() {
        assertTrue(operatorUtil.isOperator("+"));
        assertTrue(operatorUtil.isOperator("-"));
        assertTrue(operatorUtil.isOperator("*"));
        assertTrue(operatorUtil.isOperator("/"));
    }

    @Test
    public void testIsParenthesis() {
        assertTrue(operatorUtil.isParenthesis("("));
        assertTrue(operatorUtil.isParenthesis(")"));
    }

    @Test
    public void testIsLeftParenthesis() {
        assertTrue(operatorUtil.isLeftParenthesis("("));
        assertFalse(operatorUtil.isLeftParenthesis(")"));
    }

    @Test
    public void testIsRightParenthesis() {
        assertTrue(operatorUtil.isRightParenthesis(")"));
        assertFalse(operatorUtil.isRightParenthesis("("));
    }

    @Test
    public void testIsHighPriority() {
        assertTrue(operatorUtil.isHighOrEqualPriority("*", "+"));
        assertTrue(operatorUtil.isHighOrEqualPriority("*", "-"));
        assertTrue(operatorUtil.isHighOrEqualPriority("/", "+"));
        assertTrue(operatorUtil.isHighOrEqualPriority("/", "-"));
        assertTrue(operatorUtil.isHighOrEqualPriority("+", "-"));
        assertTrue(operatorUtil.isHighOrEqualPriority("*", "/"));
        assertFalse(operatorUtil.isHighOrEqualPriority("+", "*"));
        assertFalse(operatorUtil.isHighOrEqualPriority("-", "*"));
        assertFalse(operatorUtil.isHighOrEqualPriority("+", "/"));
        assertFalse(operatorUtil.isHighOrEqualPriority("-", "/"));
    }
}
