package com.basic.framework.dynamic.programming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DynamicProgrammingTest {

    @Test
    public void fibonacciTest() {
        final FibonacciCalculation calculation = new FibonacciCalculation();

        // exponential running time
        assertEquals(1134903170, calculation.recursiveFib(45));
    }

    @Test
    public void fibonacciDTest() {
        final FibonacciCalculation calculation = new FibonacciCalculation();

        // linear running time
        assertEquals(1134903170, calculation.dynamicFib(45));
    }

    @Test
    public void rodCutter() {
        final RodCutter rodCutter = new RodCutter();
        final int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        assertEquals(30, rodCutter.optimalRodCutter(price, 10));
        assertEquals(18, rodCutter.optimalRodCutter(price, 7));
        assertEquals(5, rodCutter.optimalRodCutter(price, 2));

        assertEquals(30, rodCutter.optimalRodCutterBottomUp(price, 10));
        assertEquals(18, rodCutter.optimalRodCutterBottomUp(price, 7));
        assertEquals(5, rodCutter.optimalRodCutterBottomUp(price, 2));
    }
}
