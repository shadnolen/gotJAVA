package com.company;
import java.awt.*;
public class Car {

    int averageMPG;
    String licensePlate;
    Color paint;
    boolean taillightsWorking;
    public Car(int inputAverageMPG, String inputLicensePlate, Color inputPaint, boolean inputTailLights){
        this.averageMPG = inputAverageMPG;
        this.licensePlate = inputLicensePlate;
        this.paint = inputPaint;
        this.taillightsWorking = inputTailLights;
    }
}
