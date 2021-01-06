package com.practice.designPattern.factory.easyFactory.exampleCalculator;

public class OprationAdd extends Opration{

    @Override
    public double getResults() {
        return  numberA+numberB;
    }
}
