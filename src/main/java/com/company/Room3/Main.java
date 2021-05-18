package com.company.Room3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Model model = new Model();


        List<Order> orderList = new ArrayList<>();
        BoatType kajak1 = new BoatType("kajak",2,23);
        Boat boat = new Boat(1, kajak1, 12.0, 10);
        Client client = new Client(1, "Aysegul", "Aydar", 1223456789, "Amsterdam",
                "aysegul@gmail.com", "INGB1987654321NL");
        Employee employee = new Employee(1, "Ibrahim", "Sahin", "123456789",
                "ibrahim@gmail.com");

        Order order = new Order(1, boat, client, employee,LocalDateTime.of(2021,05,15,1,30,10),
                1);

        orderList.add(order); // We need to write a method to check boat is available or not.

        model.boatTypeList.add(kajak1);
        model.boatList.add(boat);
        model.clientList.add(client);
        model.employeeList.add(employee);
        model.orderList.add(order);

        ObjectMapper mapper = new ObjectMapper();

//        // Java object to JSON file
        try {
            mapper.writeValue(new File("c:\\temp\\boatAppData.json"), model);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Enter a date for request reservation of client
        // Program will be check on this date and hours which boats are available
        // Employee select a date according to request of client or cancel the request
        // After checking reservation program give an information to client.








    }
}
