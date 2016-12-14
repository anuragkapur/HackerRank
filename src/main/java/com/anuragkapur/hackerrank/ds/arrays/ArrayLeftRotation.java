package com.anuragkapur.hackerrank.ds.arrays;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/array-left-rotation
 * Status: correct
 *
 * @author anuragkapur
 */
public class ArrayLeftRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lineElements[] = scanner.nextLine().split("\\s");
        int n = Integer.parseInt(lineElements[0]);
        int d = Integer.parseInt(lineElements[1]);

        int a[] = new int[n];

        lineElements = scanner.nextLine().split("\\s");
        for (int i=0; i<lineElements.length; i++) {
            a[i] = Integer.parseInt(lineElements[i]);
        }

        // process
        // special case - easy swap
        if (n > 1 && d == (n/2)) {
            for (int i=0; i<n/2; i++) {
                int temp = a[i];
                a[i] = a[i+d];
                a[i+d] = temp;
            }
        } else if (n > 1 && d < n) {
            // all other cases
            int swapCount = 0;
            int index = 0;

            // position new value into a[0]
            int temp = a[0];
            a[0] = a[d];

            while(swapCount < (n-1)) {

                // find new home for temp
                if (index-d < 0) {
                    index = n + (index-d);
                } else {
                    index = index-d;
                }
                int temptemp = a[index];
                a[index] = temp;
                temp = temptemp;

                swapCount++;
            }
        }


        // output
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print(a[a.length-1]);
    }
}
