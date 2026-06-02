package com.java.codes.javaconcepts;

import lombok.Data;

@Data
public class Dog {

    private String breed;
    private String parent;

    public Dog() {
    }

    public Dog(String breed, String parent) {
        this.breed = breed;
        this.parent = parent;
    }

    public void bark(String type) {
        System.out.println(type);
    }
}
