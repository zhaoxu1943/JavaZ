package com.practice.designPattern.factory.easyFactory.exampleCalculator;

public class OprationFactory {

    public  static Opration getOpration(String flag) {
        Opration opration= null;
        switch (flag) {
            case "+" :
                opration = new OprationAdd();
                break;
            case "-" :
                opration = new OprationSub();
                break;
            case "*" :
                opration = new OprationMuiti();
                break;
        }return opration;
    }

}
