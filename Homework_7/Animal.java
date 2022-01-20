package com.kd.di.abstraction;

public class Animal {
    Human human;
    Animal(Human h) {
        this.human = h;
    }
    public void getFood(Human human) {
        System.out.println("Food received from " + human);
    }

//    public Human getHuman() {
//        return human;
//    }
//
//    public void setHuman(Human human) {
//        this.human = human;
//    }
}
