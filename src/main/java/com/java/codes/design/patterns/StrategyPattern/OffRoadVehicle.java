package com.java.codes.design.patterns.StrategyPattern;

public class OffRoadVehicle extends Vehicle {

    public OffRoadVehicle(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
