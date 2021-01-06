package com.practice.designPattern.factory.factoryMethod.exampleCalculator;


//implements iFactory

public class OperationFactorySub implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}
