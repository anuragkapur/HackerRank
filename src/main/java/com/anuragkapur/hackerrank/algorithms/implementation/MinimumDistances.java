package com.anuragkapur.hackerrank.algorithms.implementation;

/**
 * https://www.hackerrank.com/challenges/minimum-distances
 *
 * Status: Correct
 *
 * @author anuragkapur
 */
import java.util.Scanner;

public class MinimumDistances {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];

        for(int i=0; i < n; i++){
            a[i] = in.nextInt();
        }

        compute1(a);
    }

    /*
     * Run time complexity:
     * (n-1) + (n-2) + ... + 1
     * = O(n^2)
     */
    private static void compute1(int[] a) {

        int d = -1;

        for (int i=0; i<a.length; i++) {
            for (int j=i+1; j<a.length; j++) {
                if (a[i] == a[j]) {
                    int distance = j - i;
                    if (distance < d || d == -1) {
                        d = distance;
                    }
                }
            }
        }

        System.out.println(d);
    }
}

