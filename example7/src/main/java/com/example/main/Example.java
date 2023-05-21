package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);


        Vehicle volkswagen = new Vehicle();
        volkswagen.setName("volkswagen");
        Supplier<Vehicle> volkswagenSupplier = () -> volkswagen;


        Supplier<Vehicle> audiSupplier = () -> {
            Vehicle audi = new Vehicle();
            audi.setName("audi");
            return audi;
        };

        Random random = new Random();
        int number = random.nextInt(10);
        System.out.println("Random number is: " + number);

        if (number % 2 == 0) {
            context.registerBean("volkswagen", Vehicle.class, volkswagenSupplier);
        } else {
            context.registerBean("audi", Vehicle.class, audiSupplier);
        }

        Vehicle volksVehicle = null;
        Vehicle audiVehicle = null;

        try {
            volksVehicle = context.getBean("volkswagen", Vehicle.class);
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error while creating Volkswagen vehicle");
        }

        try {
            audiVehicle = context.getBean("audi", Vehicle.class);
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error while creating Audi vehicle");
        }
        if (volksVehicle != null) {
            System.out.println("Programming volkswagen vehicle name from Spring context is: " + volksVehicle.getName());
        } else {
            System.out.println("Programming audi vehicle name from Spring context is: " + audiVehicle.getName());
        }

    }
}