package com.java.codes.design.patterns.StrategyPattern;

public class PassengerVehicle extends Vehicle {

    public PassengerVehicle(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
