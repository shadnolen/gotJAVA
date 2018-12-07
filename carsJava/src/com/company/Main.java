package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
	Car myCar = new Car(32.2,"4dubs",Color.cyan,false);
	Car nextCar = new Car(25.5,"iyesca",Color.black,true);
	String string1 = "I love you like a brother\n" +
            "Even though I'm not your brother\n" +
            "We all got a few flaws\n" +
            "But let's try not to get too lost in the applause";
	String string2 = "I love you like a sister\n" +
            "Even though you're not my sister\n" +
            "We all got a few flaws\n" +
            "But let's try not to get too lost";
	    System.out.println("Plate One: " + myCar.licensePlate);
        System.out.println("TailLights working car One?: " + myCar.taillightWorking);
        System.out.println("Plate One: " + myCar.paintColor);
        System.out.println("MPG  Car One: " + myCar.averageMPG);
        System.out.println("Plate Two: " + nextCar.licensePlate);
        System.out.println("TailLights working car Two?: " + nextCar.taillightWorking);
        System.out.println("Plate Two: " + nextCar.paintColor);
        System.out.println("MPG Car Two: " + nextCar.averageMPG);
        System.out.println(new StringBuilder().append(string1).append(" ").append(string2).toString());



    }
}
