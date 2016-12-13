package com.anuragkapur.hackerrank.ds.arrays;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/2d-array
 * Status: correct
 *
 * @author anuragkapur
 */
public class Array2d {

    public static void main(String[] args) {

        // read input
        Scanner scanner = new Scanner(System.in);
        int[][] a = new int[6][6];
        int lineNumber = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            }
            String[] numsAsString = line.split("\\s");
            for (int i=0; i<numsAsString.length; i++) {
                a[lineNumber][i] = Integer.parseInt(numsAsString[i]);
            }
            lineNumber ++;
        }

        // process
        int hourGlassNums[] = new int[7];
        int maxSum = 0;
        for (int i = 0; i < (6-2); i++) {
            for (int j = 0; j < (6-2); j++) {

                int count = 0;

                // row 1
                for (int k = 0; k < 3; k++) {
                    hourGlassNums[count++] = a[i][j+k];
                }

                // row 2
                hourGlassNums[count++] = a[i+1][j+1];

                // row 3
                for (int k = 0; k < 3; k++) {
                    hourGlassNums[count++] = a[i+2][j+k];
                }

                // sum of hour glass
                int sum = 0;
                for (int num : hourGlassNums) {
                    sum += num;
                }
                if (i == 0 && j == 0) {
                    maxSum = sum;
                } else {
                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }

        System.out.println(maxSum);
    }
}
