package com.company.Room3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Catalogue {
   public static List<Boat> boatList = Arrays.asList(
           new Boat(100, BoatType.KAJAK, 2, 23),
           new Boat(101, BoatType.KAJAK, 2, 23),
           new Boat(102, BoatType.KAJAK, 2, 23),
           new Boat(103, BoatType.KAJAK, 2, 23),
           new Boat(104, BoatType.KAJAK, 2, 23),
           new Boat(105, BoatType.KAJAK, 2, 23),
           new Boat(106, BoatType.KAJAK, 2, 23),
           new Boat(107, BoatType.KAJAK, 2, 23),
           new Boat(108, BoatType.KAJAK, 2, 23),
           new Boat(109, BoatType.KAJAK, 2, 23),
           new Boat(110, BoatType.KAJAK, 2, 23),
           new Boat(200,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(201,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(202,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(203,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(204,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(205,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(206,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(207,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(208,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(209,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(300,BoatType.SUPBOARD,1,17.5D),
           new Boat(301,BoatType.SUPBOARD,1,17.5D),
           new Boat(302,BoatType.SUPBOARD,1,17.5D),
           new Boat(303,BoatType.SUPBOARD,1,17.5D),
           new Boat(304,BoatType.SUPBOARD,1,17.5D),
           new Boat(305,BoatType.SUPBOARD,1,17.5D),
           new Boat(306,BoatType.SUPBOARD,1,17.5D),
           new Boat(307,BoatType.SUPBOARD,1,17.5D),
           new Boat(308,BoatType.SUPBOARD,1,17.5D),
           new Boat(309,BoatType.SUPBOARD,1,17.5D),
           new Boat(310,BoatType.SUPBOARD,1,17.5D),
           new Boat(311,BoatType.SUPBOARD,1,17.5D),
           new Boat(312,BoatType.SUPBOARD,1,17.5D),
           new Boat(313,BoatType.SUPBOARD,1,17.5D),
           new Boat(314,BoatType.SUPBOARD,1,17.5D),
           new Boat(315,BoatType.SUPBOARD,1,17.5D),
           new Boat(316,BoatType.SUPBOARD,1,17.5D),
           new Boat(317,BoatType.SUPBOARD,1,17.5D),
           new Boat(318,BoatType.SUPBOARD,1,17.5D),
           new Boat(319,BoatType.SUPBOARD,1,17.5D),
           new Boat(400,BoatType.ELECTRICALBOAT,4,30,35),
           new Boat(401,BoatType.ELECTRICALBOAT,4,30,35),
           new Boat(402,BoatType.ELECTRICALBOAT,4,30,35),
           new Boat(403,BoatType.ELECTRICALBOAT,4,30,35),
           new Boat(404,BoatType.ELECTRICALBOAT,4,30,35)
           //new Boat(405,BoatType.ELECTRICALBOAT,4,30,35)
           );


    public static boolean equals(List<Boat> boatList) {
       FIRST: for (Boat boat : boatList){
            for (Boat boat1 : boatList){
                if((boat.getBoatId() == boat1.getBoatId())){
                    continue FIRST;
                }
                return false;
            }
        }
        return true;
    }
}
