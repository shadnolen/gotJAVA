package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
	Car myCar = new Car(32.2,"4dubs",Color.cyan,false);
	Car nextCar = new Car(25.5,"iyesca",Color.black,true);
	System.out.println("Plate One: " + myCar.licensePlate);
	System.out.println("Plate One: " + nextCar.licensePlate);
    }
}
