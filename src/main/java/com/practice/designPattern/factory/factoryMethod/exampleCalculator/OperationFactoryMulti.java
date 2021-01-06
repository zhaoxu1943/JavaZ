package com.practice.designPattern.factory.factoryMethod.exampleCalculator;


//implements ifactory


public class OperationFactoryMulti implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationMuiti();
    }
}
