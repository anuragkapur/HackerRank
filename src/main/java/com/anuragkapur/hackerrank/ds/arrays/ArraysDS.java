package com.anuragkapur.hackerrank.ds.arrays;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/arrays-ds
 * Status: correct
 *
 * @author anuragkapur
 */
public class ArraysDS {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] a = new int[n];
        int i = 0;
        String numberString = scanner.nextLine();
        String numbers[] = numberString.split("\\s");
        for (String number :  numbers) {
            a[i++]  = Integer.parseInt(number);
        }

        for (int j = n-1; j > 0 ; j--) {
            System.out.print(a[j] + " ");
        }
        System.out.print(a[0]);
    }
}
