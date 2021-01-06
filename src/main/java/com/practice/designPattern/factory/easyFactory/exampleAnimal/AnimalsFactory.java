package com.practice.designPattern.factory.easyFactory.exampleAnimal;

public class AnimalsFactory {


    public static Animal createAnimals(String speakVoice) {
        Animal animal = new Animal();
        switch (speakVoice) {
            case "miao":
                animal = new Cat();
                break;
            case "wang":
                animal = new Dog();
                break;
            case "heng":
                animal = new Pig();
        }return animal;
    }

}