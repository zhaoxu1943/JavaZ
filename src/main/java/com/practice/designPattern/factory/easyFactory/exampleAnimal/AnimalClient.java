package com.practice.designPattern.factory.easyFactory.exampleAnimal;

public class AnimalClient {


    public static void main(String[] args) {
        Animal animal = null;
        animal = AnimalsFactory.createAnimals("heng");
        animal.speak();
    }



}
