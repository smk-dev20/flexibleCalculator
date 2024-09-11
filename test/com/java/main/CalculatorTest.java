package com.java.main;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {

    Calculator calc = new Calculator();
    Calculator chainCalculations = new Calculator(10);

    @Test
    public void testAddition() {
        double actualResult = calc.calculate(Operation.ADD, 10, 5);
        assertEquals(15, actualResult, 0.0001);
    }

    @Test
    public void testAdditionWithNegatives() {
        double actualResult = calc.calculate(Operation.ADD, -10, -5);
        assertEquals(-15, actualResult, 0.0001);
    }

    @Test
    public void testAdditionWithFloat() {
        double actualResult = calc.calculate(Operation.ADD, 10.2, 5.3);
        assertEquals(15.5, actualResult, 0.0001);
    }

    @Test
    public void testSubtraction() {
        double actualResult = calc.calculate(Operation.SUBTRACT, 10, 5);
        assertEquals(5, actualResult, 0.0001);
    }

    @Test
    public void testSubtractionWithNegativeResult() {
        double actualResult = calc.calculate(Operation.SUBTRACT, 5, 10);
        assertEquals(-5, actualResult, 0.0001);
    }

    @Test
    public void testMultiplication() {
        double actualResult = calc.calculate(Operation.MULTIPLY, 10, 5);
        assertEquals(50, actualResult, 0.0001);
    }

    @Test
    public void testMultiplicationWithZero() {
        double actualResult = calc.calculate(Operation.MULTIPLY, 10, 0);
        assertEquals(0, actualResult, 0.0001);
    }

    @Test
    public void testDivision() {
        double actualResult = calc.calculate(Operation.DIVIDE, 10, 5);
        assertEquals(2, actualResult, 0.0001);
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calc.calculate(Operation.DIVIDE, 10, 0);
        });
        assertEquals("Division by Zero", exception.getMessage());
    }

    @Test
    public void testUnsupportedOperation() {
        try {
            calc.calculate(Operation.valueOf("XOR"), 10, 5);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("No enum constant"));
        }
    }

    @Test
    public void testChainingOperations() {
        double actualResult = chainCalculations.calculate(Operation.ADD, 5)
                .calculate(Operation.SUBTRACT, 2)
                .calculate(Operation.MULTIPLY, 10)
                .calculate(Operation.DIVIDE, 10)
                .getResult();
        assertEquals(13, actualResult, 0.0001);
    }

    @Test
    public void testExceptionWhileChainingOperations() {
        try{
            chainCalculations.calculate(Operation.ADD, 5)
                    .calculate(Operation.SUBTRACT, 2)
                    .calculate(Operation.MULTIPLY, 10)
                    .calculate(Operation.DIVIDE, 0)
                    .getResult();
        }catch(Exception e){
            assertEquals(ArithmeticException.class, e.getClass());
        }
    }
}
