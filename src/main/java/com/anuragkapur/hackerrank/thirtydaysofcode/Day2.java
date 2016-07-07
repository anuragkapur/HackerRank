package com.anuragkapur.hackerrank.thirtydaysofcode;

import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double mealCost = scan.nextDouble(); // original meal price
        int tipPercent = scan.nextInt(); // tip percentage
        int taxPercent = scan.nextInt(); // tax percentage
        scan.close();

        // Write your calculation code here.
        double sum = mealCost + (mealCost * tipPercent)/100 + (mealCost * taxPercent)/100;

        // cast the result of the rounding operation to an int and save it as totalCost
        int totalCost = (int) Math.round(sum);

        // Print your result
        System.out.printf("The total meal cost is %d dollars.", totalCost);
    }
}