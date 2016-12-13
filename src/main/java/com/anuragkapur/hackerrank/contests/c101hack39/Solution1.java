package com.anuragkapur.hackerrank.contests.c101hack39;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @author anuragkapur
 */
public class Solution1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        String array = scan.nextLine();
        String[] splits = array.split("\\s");
        int[] a = new int[count];
        int i=0;
        for (String num : splits) {
            a[i++] = Integer.parseInt(num);
        }

        Map<Integer, Integer> numberFrequencies = new HashMap<Integer, Integer>();
        for (int num : a) {
            if (numberFrequencies.containsKey(num)) {
                int frequency = numberFrequencies.get(num);
                numberFrequencies.replace(num, frequency+1);
            } else {
                numberFrequencies.put(num, 1);
            }
        }

        Iterator<Integer> keyIterator = numberFrequencies.keySet().iterator();
        int max = -1;
        while (keyIterator.hasNext()) {
            int frequency = numberFrequencies.get(keyIterator.next());
            if (frequency > max) {
                max = frequency;
            }
        }

        System.out.println(count - max);
    }
}
