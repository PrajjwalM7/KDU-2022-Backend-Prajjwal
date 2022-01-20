package com.kd.di.abstraction;

public class Human {
    Animal animal;
    public void getMilk(Animal animal){
        System.out.println("Milk received from " + animal);
    }
    Human(Animal a) {
        this.animal = a;
    }
//    public Animal getAnimal() {
//        return animal;
//    }
//
//    public void setAnimal(Animal animal) {
//        this.animal = animal;
//    }
}
