package com.company;
import  java.*;

public class Chick {
    private String name = "Fluffy";
    { System.out.println("setting field"); }
    public Chick() {
        name = "Tiny";
        System.out.println("setting constructor");

    }
    public static void main(String[] args) {
        Chick chick = new Chick();
        System.out.println(chick.name);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(56);
        System.out.println(3);
        System.out.println(017);
        System.out.println(0x1F);

    int daysOfTheWeek = 6;
    switch(daysOfTheWeek){
        default:
            System.out.println("weekday");
            break;
        case 0:
            System.out.println("suday fun day");
            break;
        case 6:
            System.out.println("Saturday shun");
            break;
    }
    }

}