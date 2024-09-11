package com.java.main;

public class Calculator {
    private double result;
    public Calculator(){

    }
    public Calculator(double initialValue){
        this.result = initialValue;
    }

    public double calculate(Operation op, Number num1, Number num2)  {
        return op.apply(num1.doubleValue(), num2.doubleValue());
    }

    public Calculator calculate(Operation op, Number num){
        result = op.apply(result,num.doubleValue());
        return this;
    }

    public double getResult(){
        return result;
    }
}
