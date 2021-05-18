package com.company.Room3;

public class BoatType {
    private String type;
    private int seats;
    private int chargingTime;
    private double minimumPricePerHour;

    public BoatType() {
    }

    public BoatType(String type, int seats, double minimumPricePerHour) {
        this.type = type;
        this.seats = seats;
        this.minimumPricePerHour = minimumPricePerHour;
    }

    public BoatType(String type, int seats, int chargingTime, double minimumPricePerHour) {
        this.type = type;
        this.seats = seats;
        this.chargingTime = chargingTime;
        this.minimumPricePerHour = minimumPricePerHour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getChargingTime() {
        return chargingTime;
    }

    public void setChargingTime(int chargingTime) {
        this.chargingTime = chargingTime;
    }

    public double getMinimumPricePerHour() {
        return minimumPricePerHour;
    }

    public void setMinimumPricePerHour(double minimumPricePerHour) {
        this.minimumPricePerHour = minimumPricePerHour;
    }
}
