package com.company.Room3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws ParseException {
        Model model = new Model();
        model.boatList.addAll(Catalogue.kajaksList);
        model.boatList.addAll(Catalogue.rowingBoatsList);
        model.boatList.addAll(Catalogue.supBoardsList);
        model.boatList.addAll(Catalogue.electricalBoatsList);

        Client client = new Client("Aysegul", "Aydar", 1223456789, "Amsterdam",
                "aysegul@gmail.com", "INGB1987654321NL");
        Employee employee = new Employee("Ibrahim", "Sahin", "123456789",
                "ibrahim@gmail.com", "ibrahim", "12345");

        Order order = new Order(Catalogue.kajaksList.get(0), client, employee, setDate("2021-05-15 1:30:10"),
                1);

        model.clientList.add(client);
        model.employeeList.add(employee);
        model.orderList.add(order);

        ObjectMapper mapper = new ObjectMapper();

//        // Java object to JSON file
        try {
            //mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
            //mapper.writeValue(new File("c:\\temp\\boatAppData.json"), model);
            Model model1 = mapper.readValue(new File("c:\\temp\\boatAppData.json"), Model.class);
            System.out.println(model1.orderList.get(0).getRentingDate());

            Scanner scanner = new Scanner(System.in);
            boolean isAuthenticated = false;
            System.out.println("Welcome to BoatApp");
            while (!isAuthenticated) {
                System.out.print("Enter username: ");
                String userName = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                if (!authentication(userName, password, model1)) {
                    System.out.println("Incorrect username or password.\n Please try again.");
                } else {
                    isAuthenticated = true;
                }
            }

            System.out.println("To see reservations press R \n To make a new reservation press any keys");
            if(scanner.nextLine().equalsIgnoreCase("R")){
                System.out.println("BoatId\tBoatType\tTour Date\t\t\t\t\tClient Name");
                model1.orderList.stream().forEach(order1 ->
                        System.out.println(order1.getBoat().getBoatId()+"\t\t" +
                                order1.getBoat().getType()+"\t" +
                                order1.getRentingDate()+"\t" +
                                order1.getClient().getFirstName()));
                scanner.nextLine();
            }
            System.out.println("Date format should be that yyyy-MM-dd HH:mm:ss");
            System.out.print("Enter desired reservation date to see available boats: ");

            String resDate = scanner.nextLine();
            List<Boat> availableBoatList = availableBoats(resDate, model1);
            if (availableBoatList.size() == 0) {
                System.out.println("At the moment there is no available boat.");
                scanner.next();
            }
            System.out.println("Available boat info:\n id - Type - Capacity");
            availableBoatList.stream().forEach(boat2 -> System.out.println(boat2.getBoatId() + " " +
                    boat2.getType() + " " + boat2.getSeats()));

            System.out.print("Enter selected boat id: ");
            int boatId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Client Firstname: ");
            String clientFirstname = scanner.nextLine();
            System.out.print("Enter Client Lastname: ");
            String clientLastname = scanner.nextLine();
            System.out.print("Enter Client telephone number: ");
            int clientTelephoneNumber = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Client address: ");
            String clientAddress = scanner.nextLine();
            System.out.print("Enter Client email address: ");
            String clientEmailAddress = scanner.nextLine();
            System.out.print("Enter Client credit card number: ");
            String clientCreditCardNumber = scanner.nextLine();

            Client client1 = new Client(clientFirstname, clientLastname,
                    clientTelephoneNumber, clientAddress, clientEmailAddress, clientCreditCardNumber);
            System.out.format("Order Information:\n Reservation Date: %s\n Boat Type: %s\n Client Name: %s\n" +
                            "to confirm pres Y, to cancel press C: ", resDate, availableBoatList.get(0).getType(),
                    clientFirstname + " " + clientLastname);
            boolean isConfirm = false;
            while (!isConfirm) {
                String confirmOrCancel = scanner.nextLine();

                if (confirmOrCancel.equalsIgnoreCase("Y")) {
                    System.out.println("Reservation is done!");
                    Boat resBoat = new Boat();
                    for (Boat boat2 : model.boatList) {
                        if (boat2.getBoatId() == boatId)
                            resBoat = boat2;
                    }
                    Order order1 = new Order(resBoat,
                            client1, employee, setDate(resDate), 1);
                    model.orderList.add(order1);
                    mapper.writeValue(new File("c:\\temp\\boatAppData.json"), model);
                    isConfirm = true;
                } else if (confirmOrCancel.equalsIgnoreCase("C")) {
                    System.out.println("Reservation is canceled!");
                    isConfirm = true;
                } else {
                    System.out.println("Invalid selection please make valid selection");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static List<Boat> availableBoats(String date, Model model) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Boat> tempBoatList = model.boatList;
        try {
            Date date1 = formatter.parse(date);
            List<Boat> boatList = model.orderList
                    .stream().
                            filter(order -> order.getRentingDate().equals(date1))
                    .map(order -> order.getBoat())
                    .collect(Collectors.toList());

            for (Boat boat : boatList) {
                tempBoatList = tempBoatList.stream().filter(boat1 -> boat.getBoatId() != boat1.getBoatId()).collect(Collectors.toList());
            }
            return tempBoatList;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tempBoatList;
    }

    private static boolean authentication(String username, String password, Model model) {
        for (Employee employee : model.employeeList) {
            if (employee.getUserName().equals(username)) {
                if (employee.getPassword().equals(password)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    private static Date getNow() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date(System.currentTimeMillis());
        String now2 = df.format(now);
        Date date = df.parse(now2);
        return date;
    }

    private static Date setDate(String reservationDate) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = df.parse(reservationDate);
        return date;
    }
}
