package com.company.Room3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class Main2 {
    public static void main(String[] args) throws IOException, ParseException {
        /////
        ObjectMapper mapper = new ObjectMapper();
        Model model = mapper.readValue(new File("c:\\temp\\boatAppData.json"), Model.class);
        UI ui = new UI();
        ui.login(model);
        while (true) {
            int in = ui.mainMenu();
            if (in == 1) {
                ui.getReservations(model);
            } else if (in == 2) {
                ui.setReservation(mapper, model, "c:\\temp\\boatAppData.json");
            } else if (in == 3) {

            } else if (in == 4) {
                ui.addBoat(model);
            }else if(in==5){
                ui.updateBoat(model);
            }
        }
    }
}
