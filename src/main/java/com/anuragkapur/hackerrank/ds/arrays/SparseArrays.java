package com.anuragkapur.hackerrank.ds.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sparse-arrays
 * Status: correct
 *
 * @author anuragkapur
 */
public class SparseArrays {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> stringCounts = new HashMap<String, Integer>();
        int n = Integer.parseInt(scanner.nextLine());

        // parse input strings
        for (int i=0; i<n; i++) {
            String inputStr = scanner.nextLine();
            if (stringCounts.containsKey(inputStr)) {
                int count = stringCounts.get(inputStr);
                stringCounts.put(inputStr, count+1);
            } else {
                stringCounts.put(inputStr, 1);
            }
        }

        int d = Integer.parseInt(scanner.nextLine());
        for (int i=0; i<d; i++) {
            String query = scanner.nextLine();
            if (stringCounts.containsKey(query)) {
                System.out.println(stringCounts.get(query));
            } else {
                System.out.println(0);
            }
        }
    }
}
