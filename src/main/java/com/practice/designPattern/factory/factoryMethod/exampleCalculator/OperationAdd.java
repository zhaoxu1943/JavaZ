package com.practice.designPattern.factory.factoryMethod.exampleCalculator;

public class OperationAdd extends Operation {

    @Override
    public double getResults() {
        return  numberA+numberB;
    }
}
