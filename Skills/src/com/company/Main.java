package com.company;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.spi.LocaleNameProvider;
import java.util.spi.LocaleServiceProvider;

public class Main {

    public static void main(String[] args) {


	//StringBuilder a = new StringBuilder("Air D&D");
	//StringBuilder b = new StringBuilder("Rob Sonic");
	StringBuilder sb = new StringBuilder ("Defriender");
	StringBuilder sb2 = new StringBuilder("Told from the Streets");
	String s1 = "Of Da";
	String s2 = "Faith";
	String s3 = "Streets";

	int[] numbers = {0,1,2,3,4,5,6,7,8,9,};
	int[][] twoDizzle = new int[4][2];
	for(int i = 0;i < twoDizzle.length; i++){
		for(int j = 0; j < twoDizzle[i].length; j++)
			System.out.println(twoDizzle[i][j] + " ");
		System.out.println();
	}
     System.out.println(numbers);
	System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		System.out.println(LocalDate.now());


	//String sub = sb.substring(sb.indexOf("e"), sb.indexOf("ed"));
	//b = b.append(" Da O.").append("G.");

//	int len = sb.length();
//	char ch = sb.charAt(6);
		System.out.println(sb);
	System.out.println(s1 + " " + s2 + " " + s1 + " " + s3);
	System.out.println(sb2);
	System.out.println(sb == sb2);
	System.out.println(Arrays.binarySearch(numbers,22));
		System.out.println(Arrays.binarySearch(numbers,8));



		//System.out.println("a= " + a);
	//System.out.println("b= " + b);
    }
}
