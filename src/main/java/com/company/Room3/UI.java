package com.company.Room3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {
    Scanner scanner = new Scanner(System.in);

    public int mainMenu() {
        System.out.println("-----------Main Menu-----------\n" +
                "Choose an option from the following list\n" +
                "1- See reservations\n" +
                "2- Add a reservation\n" +
                "3- Update a reservation\n" +
                "4- Add a new boat to system\n" +
                "5- Update a boat\n" +
                "6- Add Employee\n" +
                "7- Return Login Screen");
        return Integer.parseInt(scanner.nextLine());
    }

    public void getReservations(Model model) {
        System.out.println("BoatId\tBoatType\tTour Date\t\t\t\t\tClient Name");
        model.orderList.stream().forEach(order1 ->
                System.out.println(order1.getBoat().getBoatId() + "\t\t" +
                        order1.getBoat().getType() + "\t" +
                        order1.getRentingDate() + "\t" +
                        order1.getClient().getFirstName()));
        scanner.nextLine();
    }

    public void setReservation(ObjectMapper mapper, Model model, String pathname) throws IOException, ParseException {
        System.out.println("Date format should be that yyyy-MM-dd HH:mm:ss");
        System.out.print("Enter desired reservation date to see available boats: ");

        String resDate = scanner.nextLine();
        System.out.print("Enter desired tour duration: ");
        int rentingDuration = Integer.parseInt(scanner.nextLine());
        List<Boat> availableBoatList = availableBoats(resDate, model);
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

                Boat resBoat = new Boat();
                for (Boat boat2 : model.boatList) {
                    if (boat2.getBoatId() == boatId)
                        resBoat = boat2;
                }
                model.orderList.add(
                        new Order(resBoat, client1, model.employeeList.get(0), setDate(resDate), rentingDuration)
                );
                mapper.writeValue(new File(pathname), model);
                isConfirm = true;
                System.out.println("Reservation is done!");
            } else if (confirmOrCancel.equalsIgnoreCase("C")) {
                System.out.println("Reservation is canceled!");
                isConfirm = true;
            } else {
                System.out.println("Invalid selection please choose an option that just in the list");
            }
        }
    }

    public void updateReservation(Model model) throws ParseException {
        model.orderList.stream().forEach(System.out::println);
        System.out.print("Choose an order by using orderID: ");
        int orderId = Integer.parseInt(scanner.nextLine());
        Optional<Order> order = model.orderList.stream().filter(o -> o.getOrderId() == orderId).findFirst();
        System.out.println(order.get());
        while (true){
            System.out.format("Choose an option from following list for number of %s:\n" +
                    "1- Change date of the reservation\n" +
                    "2- Change client information of the customer\n" +
                    "3- Change the boat\n"+
                    "4- Delete the reservation\n" +
                    "5- Exit\n", orderId);
            String userSelection = scanner.nextLine();
            if(userSelection.equalsIgnoreCase("1")){
                System.out.println("Date format should be that yyyy-MM-dd HH:mm:ss");
                System.out.print("Enter the new date: ");
                String resDate = scanner.nextLine();
                order.get().setRentingDate(setDate(resDate));
                System.out.println(order.get());
            }else if(userSelection.equalsIgnoreCase("2")){
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
                order.get().getClient().setFirstName(clientFirstname);
                order.get().getClient().setLastName(clientLastname);
                order.get().getClient().setTelephoneNumber(clientTelephoneNumber);
                order.get().getClient().setAddress(clientAddress);
                order.get().getClient().setEmailAddress(clientEmailAddress);
                System.out.println(order.get().getClient());
            }else if(userSelection.equalsIgnoreCase("3")){
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String resDate = df.format(order.get().getRentingDate());
                List<Boat> availableBoatList = availableBoats(resDate, model);
                if (availableBoatList.size() == 0) {
                    System.out.println("At the moment there is no available boat.");
                    scanner.next();
                }
                System.out.println("Available boat info:\n id - Type - Capacity");
                availableBoatList.stream().forEach(boat2 -> System.out.println(boat2.getBoatId() + " " +
                        boat2.getType() + " " + boat2.getSeats()));

                System.out.print("Select the new boat by using boatID: ");
                int boatId = Integer.parseInt(scanner.nextLine());
                Optional<Boat> newBoat = availableBoatList.stream().filter(boat -> boat.getBoatId() == boatId).findFirst();
                order.get().setBoat(newBoat.get());
                System.out.println(order.get().getBoat());
            }else if(userSelection.equalsIgnoreCase("4")){
                model.orderList.removeIf(order1 -> order1.getOrderId()==orderId);
                model.orderList.stream().forEach(System.out::println);
            }else if (userSelection.equalsIgnoreCase("5")){
                break;
            }else {
                System.out.println("Invalid selection please choose an option that just in the list");
            }
        }
    }
    public void addBoat(Model model) {
        System.out.println("Choose the boat type:\n" +
                "1- KAJAK\n" +
                "2- SUPBOARD\n" +
                "3- ROWINGBOAT\n" +
                "4- ELECTRICALBOAT ");
        BoatType boatType = null;
        int chargingTime = 0;
        int boatListLength = model.boatList.size();
        int boatId = 0;
        while (true) {
            String userBoatTypeSelection = scanner.nextLine();
            if (userBoatTypeSelection.equals("1")) {
                boatType = BoatType.KAJAK;
                long count = model.boatList.stream().filter(boat -> boat.getType().equals(BoatType.KAJAK)).count();
                boatId = 100 + (int) ++count;
                break;
            } else if (userBoatTypeSelection.equals("2")) {
                boatType = BoatType.SUPBOARD;
                long count = model.boatList.stream().filter(boat -> boat.getType().equals(BoatType.SUPBOARD)).count();
                boatId = 300 + (int) ++count;
                break;
            } else if (userBoatTypeSelection.equals("3")) {
                boatType = BoatType.ROWINGBOAT;
                long count = model.boatList.stream().filter(boat -> boat.getType().equals(BoatType.ROWINGBOAT)).count();
                boatId = 200 + (int) ++count;
                break;
            } else if (userBoatTypeSelection.equals("4")) {
                boatType = BoatType.ELECTRICALBOAT;
                long count = model.boatList.stream().filter(boat -> boat.getType().equals(BoatType.ELECTRICALBOAT)).count();
                boatId = 400 + (int) ++count;
                System.out.print("Enter the charging time: ");
                chargingTime = Integer.parseInt(scanner.nextLine());
                break;
            } else
                System.out.println("Invalid selection please choose an option that just in the list");
        }
        System.out.print("Enter the seat number of the boat: ");

        int boatSeats = Integer.parseInt(scanner.nextLine());
        if (boatType.equals(BoatType.ELECTRICALBOAT)) {

        }
        System.out.print("Enter the boat's minimum price per hour: ");
        int minimumPricePerHour = Integer.parseInt(scanner.nextLine());
        System.out.format("Boat Information:\n Boat Type: %s\nBoat Seats: %s\nMinimum Price: %s\n" +
                "to confirm pres Y, to cancel press C: ", boatType, boatSeats, minimumPricePerHour);

        while (true) {
            String isConfirm = scanner.nextLine();
            if (isConfirm.equalsIgnoreCase("Y")) {
                if (boatType.equals(BoatType.ELECTRICALBOAT)) {
                    model.boatList.add(new Boat(boatId, boatType, boatSeats, chargingTime, minimumPricePerHour));
                } else {
                    model.boatList.add(new Boat(boatId, boatType, boatSeats, minimumPricePerHour));
                }
                System.out.println(model.boatList.get(model.boatList.size() - 1).getBoatId() +
                        "\n" + model.boatList.get(model.boatList.size() - 1).getMinimumPricePerHour());
                break;
            } else if (isConfirm.equalsIgnoreCase("C")) {
                break;
            } else {
                System.out.println("Invalid selection please choose an option that just in the list");
            }
        }
    }

    public void updateBoat(Model model) {
        model.boatList.stream().forEach(System.out::println);
        System.out.print("Select a boat by using boatId");
        int boatId = Integer.parseInt(scanner.nextLine());
        Optional<Boat> boat = model.boatList.stream().filter(boat1 -> boat1.getBoatId() == boatId).findFirst();
        System.out.println(boat.toString());
        while (true) {

            System.out.format("Choose an option from following list for number of %s:\n" +
                    "1- Change number of seats\n" +
                    "2- Change minimum price per hour\n" +
                    "3- Change charging time\n" +
                    "4- Delete\n" +
                    "5- Exit\n", boatId);
            String userSelection = scanner.nextLine();
            if (userSelection.equalsIgnoreCase("1")) {
                System.out.print("Enter the new seats number: ");
                int seatNumber = Integer.parseInt(scanner.nextLine());
                boat.get().setSeats(seatNumber);
                System.out.println(boat.get().toString());
            } else if (userSelection.equalsIgnoreCase("2")) {
                System.out.print("Enter the new minimum price per hour: ");
                double minPrice = Double.parseDouble(scanner.nextLine());
                boat.get().setMinimumPricePerHour(minPrice);
                System.out.println(boat.get().toString());
            } else if (userSelection.equalsIgnoreCase("3")) {
                System.out.print("Enter the new charging time: ");
                int chargingTime = Integer.parseInt(scanner.nextLine());
                boat.get().setChargingTime(chargingTime);
                System.out.println(boat.get().toString());
            } else if (userSelection.equalsIgnoreCase("4")) {
                model.boatList.removeIf(boat1 -> boat1.getBoatId() == boatId);
                model.boatList.stream().forEach(System.out::println);
            } else if (userSelection.equalsIgnoreCase("5")) {
                break;
            } else {
                System.out.println("Invalid selection please choose an option that just in the list");
            }

        }
    }

    public void addEmployee(Model model){
        System.out.print("Enter firstname: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter lastname: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter telephone number: ");
        String telephoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();
        System.out.print("Enter username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        model.employeeList.add(new Employee(firstName,lastName,telephoneNumber,emailAddress,userName,password));
        model.employeeList.stream().forEach(System.out::println);
    }

    public void login(Model model) {
/*
        System.out.println("Enter username and password\n" +
                "Press Q to quit from App");
*/
        boolean isAuthenticated = false;
        System.out.println("Welcome to BoatApp");
        while (!isAuthenticated) {
            System.out.print("Enter username: ");
            String userName = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            if (!authentication(userName, password, model)) {
                System.out.println("Incorrect username or password.\n Please try again.");
            } else {
                isAuthenticated = true;
            }
        }
    }

    private List<Boat> availableBoats(String date, Model model) {
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

    private boolean authentication(String username, String password, Model model) {
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

    private Date setDate(String reservationDate) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = df.parse(reservationDate);
        return date;
    }
}
