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

    int lyrics = 6;
    switch(lyrics){
        default:
            System.out.println("Used to be rock, but now it's roll\n" +
                    "Looking at the clock and the remote control\n" +
                    "The circle contracts till you all alone");
            break;
        case 0:
            System.out.println("I put that on the people you've outgrown\n" +
                    "And maybe it was all for show\n" +
                    "But it was so convincing that the ground got cold");
            break;
        case 6:
            System.out.println(" love you like a brother\n" +
                    "Even though I'm not your brother\n" +
                    "We all got a few flaws\n" +
                    "But let's try not to get too lost in the applause\n" +
                    "I love you like a sister\n" +
                    "Even though you're not my sister\n" +
                    "We all got a few flaws\n" +
                    "But let's try not to get too lost");
            break;
    }
    }

}