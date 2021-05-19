package com.company.Room3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Catalogue {
   public static List<Boat> kajaksList = Arrays.asList(
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
           new Boat(110, BoatType.KAJAK, 2, 23)
           );
   public static List<Boat> rowingBoatsList = Arrays.asList(
           new Boat(200,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(201,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(202,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(203,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(204,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(205,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(206,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(207,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(208,BoatType.ROWINGBOAT,4,27.5D),
           new Boat(209,BoatType.ROWINGBOAT,4,27.5D)
   );
   public static List<Boat> supBoardsList = Arrays.asList(
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
           new Boat(319,BoatType.SUPBOARD,1,17.5D)

   );
   public static List<Boat> electricalBoatsList = Arrays.asList(
           new Boat(400,BoatType.ELECTRICALBOAT,4,30,35),
           new Boat(401,BoatType.ELECTRICALBOAT,4,30,35),
           new Boat(402,BoatType.ELECTRICALBOAT,4,30,35),
           new Boat(403,BoatType.ELECTRICALBOAT,4,30,35),
           new Boat(404,BoatType.ELECTRICALBOAT,4,30,35)
   );

    /*KAJAKS
    Boat kajak1 = new Boat(100, BoatType.KAJAK, 2, 23);
    Boat kajak2 = new Boat(101, BoatType.KAJAK, 2, 23);
    Boat kajak3 = new Boat(102, BoatType.KAJAK, 2, 23);
    Boat kajak4 = new Boat(103, BoatType.KAJAK, 2, 23);
    Boat kajak5 = new Boat(104, BoatType.KAJAK, 2, 23);
    Boat kajak6 = new Boat(105, BoatType.KAJAK, 2, 23);
    Boat kajak7 = new Boat(106, BoatType.KAJAK, 2, 23);
    Boat kajak8 = new Boat(107, BoatType.KAJAK, 2, 23);
    Boat kajak9 = new Boat(108, BoatType.KAJAK, 2, 23);
    Boat kajak10 = new Boat(109, BoatType.KAJAK, 2, 23);

    //ROWINGBOATS
    Boat rowingBoat1 = new Boat(200,BoatType.ROWINGBOAT,4,27.5D);
    Boat rowingBoat2 = new Boat(201,BoatType.ROWINGBOAT,4,27.5D);
    Boat rowingBoat3 = new Boat(202,BoatType.ROWINGBOAT,4,27.5D);
    Boat rowingBoat4 = new Boat(203,BoatType.ROWINGBOAT,4,27.5D);
    Boat rowingBoat5 = new Boat(204,BoatType.ROWINGBOAT,4,27.5D);
    Boat rowingBoat6 = new Boat(205,BoatType.ROWINGBOAT,4,27.5D);
    Boat rowingBoat7 = new Boat(206,BoatType.ROWINGBOAT,4,27.5D);
    Boat rowingBoat8 = new Boat(207,BoatType.ROWINGBOAT,4,27.5D);
    Boat rowingBoat9 = new Boat(208,BoatType.ROWINGBOAT,4,27.5D);
    Boat rowingBoat10 = new Boat(209,BoatType.ROWINGBOAT,4,27.5D);

    //SUPBOARD
    Boat supBoard1 = new Boat(300,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard2 = new Boat(301,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard3 = new Boat(302,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard4 = new Boat(303,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard5 = new Boat(304,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard6 = new Boat(305,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard7 = new Boat(306,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard8 = new Boat(307,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard9 = new Boat(308,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard10 = new Boat(309,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard11 = new Boat(310,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard12 = new Boat(311,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard13 = new Boat(312,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard14 = new Boat(313,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard15 = new Boat(314,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard16 = new Boat(315,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard17 = new Boat(316,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard18 = new Boat(317,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard19 = new Boat(318,BoatType.SUPBOARD,1,17.5D);
    Boat supBoard20 = new Boat(319,BoatType.SUPBOARD,1,17.5D);

    //ELECTRICALBOAT
    Boat electricalBoat1 = new Boat(400,BoatType.ELECTRICALBOAT,4,30,35);
    Boat electricalBoat2 = new Boat(401,BoatType.ELECTRICALBOAT,4,30,35);
    Boat electricalBoat3 = new Boat(402,BoatType.ELECTRICALBOAT,4,30,35);
    Boat electricalBoat4 = new Boat(403,BoatType.ELECTRICALBOAT,4,30,35);
    Boat electricalBoat5 = new Boat(404,BoatType.ELECTRICALBOAT,4,30,35);
    */
}
