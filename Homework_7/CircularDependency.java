package com.kd.di.spring.xml;

import com.kd.di.abstraction.Animal;
import com.kd.di.abstraction.Human;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependency {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("circularDependency.xml");
        Human human = applicationContext.getBean(Human.class);

        Animal animal = applicationContext.getBean(Animal.class);
        human.getMilk(animal);
        animal.getFood(human);
//
//        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("beans-factory.xml");
//        applicationContext1.getBean(Application.class).makeDrawing();

//        ApplicationContext context = new ClassPathXmlApplicationContext("beans-collection.xml");
//        final SampleCollection sampleCollection = context.getBean(SampleCollection.class);
//        System.out.println(sampleCollection.getMapOfEmailAndPhoneNumbers());
//        System.out.println(sampleCollection.getSomeEmails());
//        System.out.println(sampleCollection.getSetOfPhoneNumbers());
    }
}
