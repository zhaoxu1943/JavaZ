package com.practice.designPattern.factory.factoryMethod.exampleCalculator;


//简单工厂模式是多态的应用
//最基础的是一个父类和多个实现的子类
//工厂通过switch case 来选择合适的子类对象去生成
//供客户端去调用
public class Operation {

    public  double numberA;
    public double numberB;

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }


    public  double  getResults(){
        return 0;
    }


}
