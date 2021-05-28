package com.company.Room3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class Main2 {
    public static void main(String[] args) throws IOException, ParseException {
        ObjectMapper mapper = new ObjectMapper();
        Model model = mapper.readValue(new File("boatAppData.json"), Model.class);
        UI ui = new UI();
        MAIN:while (true) {
            ui.login(model);
            while (true) {
                int in = ui.mainMenu();
                if (in == 1) {
                    ui.getReservations(model);
                } else if (in == 2) {
                    ui.setReservation(mapper, model, "boatAppData.json");
                } else if (in == 3) {
                    ui.updateReservation(model);
                } else if (in == 4) {
                    ui.addBoat(model);
                } else if (in == 5) {
                    ui.updateBoat(model);
                } else if (in == 6) {
                    ui.addEmployee(model);
                } else if (in == 7) {
                    break;
                }else if(in==8){
                    System.out.println("Fijne Dagg...");
                   break MAIN;
                }else {
                    System.out.println("Invalid selection please choose an option that just in the list");
                }
            }
        }
    }
}
