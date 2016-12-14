package com.anuragkapur.hackerrank.algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/hackerland-radio-transmitters
 * Status: incorrect
 *
 * @author anuragkapur
 */
public class HackerlandRadioTransmitters {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }

        // sort
        Arrays.sort(x);

        int left = 0;
        int right = left + 1;
        int position = -1;
        int count = 0;

        while (left < n && right < n) {

            if (x[right] - x[left] == k) {
                position = right;
                count ++;

                // find right range from position
                left = position;
                right = left + 1;
                while (left < n && right < n) {
                    if (x[right] - x[left] == k) {
                        // range found
                        left = right + 1;
                        right = left + 1;
                        break;
                    } else if (x[right] - x[left] < k) {
                        right ++;
                    } else if (x[right] - x[left] > k) {
                        left = left + 1;
                        right = left + 1;
                        break;
                    }
                }
            } else if(x[right] - x[left] < k) {
                right ++;
            } else if(x[right] - x[left] > k) {
                count ++;
                left = right + 1;
                right = left + 1;
            }
        }

        if (position < left && left < n) {
            count ++;
        }

        System.out.println(count);
    }
}
