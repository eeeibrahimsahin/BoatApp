package com.company.Room3;

import java.time.LocalDateTime;
import java.util.Date;

public class Order {
    /**
     * BookingDate is made reservation date
     * RentingDuration is minimal one hour and it refers hour.
     * RentingDate is the date boat will be used.
     * Total price = duration * boat's hourly price.
     */
    private static int count = 1;
    private int orderId;
    private Boat boat;
    private Client client;
    private Employee employee;
    private Date rentingDate;
    private int rentingDuration;
    private Date bookingDate;
    private double totalPrice;

    public Order() {
    }

    public Order(Boat boat, Client client, Employee employee, Date rentingDate,
                 int rentingDuration) {
        this.orderId = count;
        this.boat = boat;
        this.client = client;
        this.employee = employee;
        this.rentingDate = rentingDate;
        this.rentingDuration = rentingDuration;
        this.bookingDate = new Date(System.currentTimeMillis());
        calculateTotalPrice(boat.getMinimumPricePerHour());
        count++;
    }

    public int getOrderId() {
        return orderId;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public Date getRentingDate() {
        return rentingDate;
    }

    public void setRentingDate(Date rentingDate) {
        this.rentingDate = rentingDate;
    }

    public int getRentingDuration() {
        return rentingDuration;
    }

    public void setRentingDuration(int rentingDuration) {
        this.rentingDuration = rentingDuration;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private void calculateTotalPrice(double hourlyBoatPrice) {
        this.totalPrice = hourlyBoatPrice * rentingDuration;
    }
}
