package com.company.Room3;

public class Boat {
    /**
     * Two types boat: Gasoline and Electricity
     * hourlyPrice: Hourly price's currency is euro.
     */
    private int boatId; //We can generate automatically
    private BoatType type;
    private double hourlyPrice;
    private int passengerCapacity;

    public Boat() {
    }

    public Boat(int boatId, BoatType type, double hourlyPrice, int passengerCapacity) {
        this.boatId = boatId;
        this.type = type;
        this.hourlyPrice = hourlyPrice;
        this.passengerCapacity = passengerCapacity;

    }

    public int getBoatId() {
        return boatId;
    }

    public BoatType getType() {
        return type;
    }

    public void setType(BoatType type) {
        this.type = type;
    }

    public double getHourlyPrice() {
        return hourlyPrice;
    }

    public void setHourlyPrice(double hourlyPrice) {
        this.hourlyPrice = hourlyPrice;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
