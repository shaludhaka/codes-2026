package com.java.codes.design.patterns.StrategyPattern;

public class SportsVehicle extends Vehicle {

    public SportsVehicle(){
        super(new SportsDrive());

    }

    public SportsVehicle(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
