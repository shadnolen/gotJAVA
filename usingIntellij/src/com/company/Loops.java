package com.company;

public class Loops {
    public static void main(String[] args){
        System.out.println("print counting from uno to a rack");
        for(int i=1;i<=1000;i++){
            System.out.println(i + " ");
        }
        System.out.println();
        System.out.println("\nFibonacci skills upto a rack!!");
        for(int fib=0, step=1;fib<1000; fib=fib+step, step=fib-step)
            System.out.println(fib + " ");
        for(;;){
            System.out.println("\nAll Time" );
            break;

        }
    }
}
