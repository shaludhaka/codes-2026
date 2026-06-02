package com.java.codes.design.patterns.StrategyPattern;

public class Client {

    public static void main(String[] args) {

        DriveStrategy offRoad = new SportsDrive();

        Vehicle vehicle =  new OffRoadVehicle(offRoad);
        vehicle.drive();

        vehicle = new PassengerVehicle(new NormalDrive());
        vehicle.drive();
    }
}
