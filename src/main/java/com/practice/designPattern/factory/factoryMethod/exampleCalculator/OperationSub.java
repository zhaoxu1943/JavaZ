package com.practice.designPattern.factory.factoryMethod.exampleCalculator;

public class OperationSub extends Operation {
    @Override
    public double getResults() {
        return  numberA-numberB;
    }
}
