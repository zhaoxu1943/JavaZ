package com.practice.designPattern.factory.factoryMethod.exampleCalculator;

//建立工厂接口
//compare with easy factory
//not judge in factory rather than judge in client
interface IFactory {
    Operation createOperation();
}
