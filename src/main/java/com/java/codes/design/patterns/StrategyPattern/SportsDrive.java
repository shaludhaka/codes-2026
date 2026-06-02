package com.java.codes.design.patterns.StrategyPattern;

public class SportsDrive implements DriveStrategy {

    @Override
    public void drive() {

        System.out.println("Sports drive");
    }
}
