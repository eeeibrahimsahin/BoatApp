package com.company.Room3;

public class Boat {
    /**
     * Two types boat: Gasoline and Electricity
     * hourlyPrice: Hourly price's currency is euro.
     */
    private int boatId; //We can generate automatically
    private String type;
    private double hourlyPrice;
    private int passengerCapacity;

    public Boat(int boatId, String type, double hourlyPrice, int passengerCapacity) {
        this.boatId = boatId;
        this.type = type;
        this.hourlyPrice = hourlyPrice;
        this.passengerCapacity = passengerCapacity;

    }

    public int getBoatId() {
        return boatId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
