package com.anuragkapur.hackerrank.algorithms.dp;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/fibonacci-modified
 *
 * Status: Correct
 *
 * Run time complexity:
 * To compute the nth modified fib number, we need to compute all previous fib numbers. Thus, O(n), where n is the term
 * whose value is required
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

        System.out.println(computeNth(a, b, n));
    }

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
}
