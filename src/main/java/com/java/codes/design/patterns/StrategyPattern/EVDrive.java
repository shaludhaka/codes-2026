package com.java.codes.design.patterns.StrategyPattern;

public class EVDrive implements DriveStrategy {

    @Override
    public void drive() {

        System.out.println("EV drive");
    }
}
