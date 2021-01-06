package com.practice.designPattern.factory.factoryMethod.exampleCalculator;

public class CalculatorClient {
    public static void main(String[] args) {
        //judge in client
        //just like list and ArrayList
       Operation operation;
       IFactory factory = new OperationFactoryMulti();
       operation = factory.createOperation();
       operation.setNumberA(12121);
       operation.setNumberB(3213);
       System.out.print(operation.getResults());
    }
}
