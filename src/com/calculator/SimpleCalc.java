package com.calculator;

public class SimpleCalc {
    protected int calc(int a, String action, int b) {
        int result;

        switch (action) {
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
            case "/": result = a / b; break;
            default: result = -10000;
        }

        return result;
    }
}
