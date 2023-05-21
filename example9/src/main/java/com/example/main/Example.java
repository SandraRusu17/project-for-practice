package com.example.main;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle veh = context.getBean(Vehicle.class);
        Person pers = context.getBean(Person.class);

        System.out.println("Vehicle name from Spring context is: " + veh.getName());
        System.out.println("Person's vehicle from Spring context is: " + pers.getVehicle());


    }
}