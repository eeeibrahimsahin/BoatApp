package com.company.Room3;

import java.time.LocalDateTime;

public class Order {
    /**
     * BookingDate is made reservation date
     * RentingDuration is minimal one hour and it refers hour.
     * RentingDate is the date boat will be used.
     * Total price = duration * boat's hourly price.
     */
    private int orderId; //We can generate automatically
    private Boat boat;
    private Client client;
    private Employee employee;
    private LocalDateTime rentingDate;
    private int rentingDuration;
    private LocalDateTime bookingDate;
    private double totalPrice;

    public Order(int orderId, Boat boat, Client client, Employee employee, LocalDateTime rentingDate,
                 int rentingDuration) {
        this.orderId = orderId;
        this.boat = boat;
        this.client = client;
        this.employee = employee;
        this.rentingDate = rentingDate;
        this.rentingDuration = rentingDuration;
        this.bookingDate = LocalDateTime.now();
        calculateTotalPrice(boat.getHourlyPrice());
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


    public LocalDateTime getRentingDate() {
        return rentingDate;
    }

    public void setRentingDate(LocalDateTime rentingDate) {
        this.rentingDate = rentingDate;
    }

    public int getRentingDuration() {
        return rentingDuration;
    }

    public void setRentingDuration(int rentingDuration) {
        this.rentingDuration = rentingDuration;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private void calculateTotalPrice(double hourlyBoatPrice) {
        this.totalPrice = hourlyBoatPrice * rentingDuration;
    }
}
