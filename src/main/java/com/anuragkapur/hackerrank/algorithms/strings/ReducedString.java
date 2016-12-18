package com.anuragkapur.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/reduced-string
 * Status: correct
 *
 * @author anuragkapur
 */
public class ReducedString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(reduce(input));
    }

    private static String reduce(String str) {

        if (str.equals("")) {

            return "Empty String";
        } else {

            String reducedStr = removeAdjacentPair(str);
            if (reducedStr.length() == str.length()) {
                return str;
            } else {
                return reduce(reducedStr);
            }
        }
    }

    private static String removeAdjacentPair(String str) {

        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = str.toCharArray();
        boolean duplicatePairFound = false;
        for (int i = 0; i < chars.length; i++) {

            if (( (i+1) < chars.length) && chars[i] == chars[i+1] && !duplicatePairFound) {
                // just ignore 1 duplicate pair in 1 invocation of this method
                duplicatePairFound = true;
                i++;
            } else {
                stringBuilder.append(chars[i]);
            }
        }

        return stringBuilder.toString();
    }
}
