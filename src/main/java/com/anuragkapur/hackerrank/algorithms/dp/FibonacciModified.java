package com.anuragkapur.hackerrank.algorithms.dp;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/fibonacci-modified
 *
 * Status: Correct
 *
 * @author anuragkapur
 */
public class FibonacciModified {

    public static void main(String[] args) {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] splits = input.split("\\s");
        String a = splits[0];
        String b = splits[1];
        int n = Integer.parseInt(splits[2]);

        //System.out.println(computeNth(a, b, n));
        System.out.println(computeNth1(a, b, n));
    }

    /*
     * Simple recursive approach, with repeated sub-problems
     *
     * Run time complexity:
     * T(n) = T(n-1) + T(n-2) + O(1)
     *      = O(2^n)
     *
     */
    private static BigInteger computeNth(String a, String b, int n) {


        if (n == 1) {
            return new BigInteger(a);
        } else if (n == 2) {
            return new BigInteger(b);
        } else {
            BigInteger n1 = computeNth(a, b, n-1);
            return n1.pow(2).add(computeNth(a, b, n-2));
        }
    }

    /*
     * Bottom up, DP
     *
     * Run time complexity:
     * To compute the nth modified fib number, we need to compute all previous fib numbers.
     * Thus, O(n), where n is the term whose value is required.
     */
    private static BigInteger computeNth1(String a, String b, int n) {

        BigInteger[] series = new BigInteger[n];

        series[0] = new BigInteger(a);
        series[1] = new BigInteger(b);

        for (int i=2; i<n; i++) {
            series[i] = series[i-1].pow(2).add(series[i-2]);
        }

        return series[n-1];
    }
}
