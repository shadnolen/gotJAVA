package com.company;

import java.awt.*;

public class Car {
    //datatypes
    double averageMPG;
    String licensePlate;
    Color paintColor;
    Boolean taillightWorking;


    public Car(double inputAverageMPG, String inputLicensePlate, Color inputPaintColor, Boolean inputTaillightWorking ){
        this.averageMPG = inputAverageMPG;
        this.licensePlate = inputLicensePlate;
        this.paintColor = inputPaintColor;
        this.taillightWorking = inputTaillightWorking;

    }
}