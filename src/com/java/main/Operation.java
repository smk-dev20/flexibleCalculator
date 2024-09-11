package com.java.main;

public enum Operation {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE;

    public double apply(double num1, double num2){
        switch(this){
            case ADD: return num1 + num2;
            case SUBTRACT: return num1 - num2;
            case MULTIPLY: return  num1 * num2;
            case DIVIDE:
                if(num2 == 0){
                    throw new ArithmeticException("Division by Zero");
                }
                return num1/num2;
        }
        throw new UnsupportedOperationException("Undefined Operation: "+this);
    }
}
