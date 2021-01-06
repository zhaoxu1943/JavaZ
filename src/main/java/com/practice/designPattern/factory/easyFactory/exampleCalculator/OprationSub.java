package com.practice.designPattern.factory.easyFactory.exampleCalculator;

public class OprationSub extends Opration {
    @Override
    public double getResults() {
        return  numberA-numberB;
    }
}
