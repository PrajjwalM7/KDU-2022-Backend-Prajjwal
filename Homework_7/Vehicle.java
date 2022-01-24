package com.kd.di.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Vehicle {
    private int tyres;
    private Car car;
    public int getTyres() {
        return this.tyres;
    }
    public Car getCar() {
        return this.car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public void setTyres(int n) {
        this.tyres = n;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("vehicleXML.xml");

        // 3 types of getBean()
        Vehicle v = context.getBean(Vehicle.class);
        Vehicle v1 = context.getBean(Vehicle.class);

        Car bmw = context.getBean("bmw", Car.class);
        Car bmw2 = (Car) context.getBean("bmw2");

        System.out.println("No of tyres and name of Car: " + v.getTyres() + " and " + v.getCar().name);
        System.out.println("Name of the car : " + bmw.name);
        System.out.println("Scope Singleton, hence returns the same object -> " + (v == v1));
        System.out.println("Scope prototype, hence returns two different objects -> " + (bmw == bmw2));

        System.out.println("ApplicationContext methods :");
        System.out.println("Application Name - " + context.getApplicationName());
        System.out.println("Display Name - " +  context.getDisplayName());
        System.out.println("ID - " + context.getId());
        System.out.println("Parent - " + context.getParent());
        System.out.println("Startup Date - " + context.getStartupDate());
        System.out.println("Contains bean bmw - " + context.containsBean("bmw"));
        System.out.println(context.getBeanDefinitionCount() + " beans found");
        String s[] = context.getBeanNamesForType(Car.class);
        System.out.println("Beans of type Car : ");
        for(String str : s) {
            System.out.println(str);
        }
        s = context.getBeanNamesForType(Vehicle.class);
        System.out.println("Beans of type Vehicle : ");
        for(String str : s) {
            System.out.println(str);
        }
    }
}

class Car {
    String name;

    public Car(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("Initialised the car bean building process.");
    }

    public void destroy() {
        System.out.println("Destroying Car bean");
    }
}
