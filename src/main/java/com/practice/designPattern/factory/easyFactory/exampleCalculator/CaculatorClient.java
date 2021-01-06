package com.practice.designPattern.factory.easyFactory.exampleCalculator;

public class CaculatorClient {
    public static void main(String[] args) {
        Opration opration;
        opration =OprationFactory.getOpration("-");
        opration.setNumberA(321);
        opration.setNumberB(3433);
        System.out.print(opration.getResults());

    }
}
