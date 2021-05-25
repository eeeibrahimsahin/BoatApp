package com.company.Room3;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public List<Boat> boatList = new ArrayList<>();
    public List<Employee> employeeList = new ArrayList<>();
    public List<Client> clientList = new ArrayList<>();
    public List<Order> orderList = new ArrayList<>();



    public Boat createBoat(int boatId,BoatType boatType,int seats, double minimumPricePerHour){
        Boat newBoat = new Boat(boatId,boatType,seats,minimumPricePerHour);
        return newBoat;
    }
    public Boat createBoat(int boatId,BoatType boatType,int seats,int chargingTime, double minimumPricePerHour){
        Boat newBoat = new Boat(boatId,boatType,seats,chargingTime,minimumPricePerHour);
        return newBoat;
    }


    public void updateBoat(List<Boat> boatList, int boatId,double minimumPricePerHour){
        for (Boat boat : boatList){
            if(boat.getBoatId()==boatId){
                boat.setMinimumPricePerHour(minimumPricePerHour);
            }
        }
    }

    public void updateBoat(List<Boat> boatList, int boatId,double minimumPricePerHour,int chargingTime){
        for (Boat boat : boatList){
            if(boat.getBoatId()==boatId){
                boat.setMinimumPricePerHour(minimumPricePerHour);
                boat.setChargingTime(chargingTime);
            }
        }
    }

    public void deleteBoat(List<Boat> boatList,int boatId){
       // boatList.removeIf(boat -> boat.getBoatId()==boatId);
        for(int i=0; i<boatList.size(); i++){
            if(boatList.get(i).getBoatId()==boatId){
                boatList.remove(boatList.get(i));
            }
        }

    }

    @Override
    public String toString() {
        return "Model{" +
                "boatList=" + boatList +
                ", employeeList=" + employeeList +
                ", clientList=" + clientList +
                ", orderList=" + orderList +
                '}';
    }
}
