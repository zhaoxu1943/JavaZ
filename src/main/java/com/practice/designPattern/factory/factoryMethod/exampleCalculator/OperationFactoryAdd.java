package com.practice.designPattern.factory.factoryMethod.exampleCalculator;


//implements iFactory

public class OperationFactoryAdd implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
