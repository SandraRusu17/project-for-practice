package com.example.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Vehicle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Print Hello World from Component Vehicle Bean");
    }

}