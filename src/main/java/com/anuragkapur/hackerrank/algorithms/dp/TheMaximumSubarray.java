package com.anuragkapur.hackerrank.algorithms.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/maxsubarray
 *
 * Status: Correct
 *
 * @author anuragkapur
 */
public class TheMaximumSubarray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = Integer.parseInt(scanner.nextLine());

        for (int i=0; i<noOfTestCases; i++) {
            int noOfElements = Integer.parseInt(scanner.nextLine());
            int a[] = new int[noOfElements];
            int k = 0;
            String inputArray = scanner.nextLine();
            for(String num : inputArray.split("\\s")) {
                a[k++] = Integer.parseInt(num);
            }

            System.out.println(maxSubArraySum(a, 0, a.length-1) + " " + maxSum(a));
        }
    }

    /*
     * Run time complexity:
     * O(n) + O(n * log n) = O(n * log n)
     */
    private static int maxSum(final int[] a) {

        int sum = 0;
        boolean allNegative = true;

        for (int num : a) {
            if (num > 0) {
                allNegative = false;
                sum += num;
            }
        }

        if (allNegative) {
            Arrays.sort(a);
            sum = a[a.length-1];
        }

        return sum;
    }

    /*
     * T(n) = T(n/2) + T(n/2) + O(n) (same recursion as merge sort)
     *      = O(n log n)
     */
    private static int maxSubArraySum(int[] a, int l, int r) {

        if (l == r) {
            return a[l];
        }

        int mid = (l + r) / 2;

        int sumLeft = maxSubArraySum(a, l, mid);
        int sumRight = maxSubArraySum(a, mid+1, r);
        int sumMid = sumMid(a, l, r, mid);

        int possibleMax = Math.max(sumLeft, sumRight);
        return Math.max(possibleMax, sumMid);
    }

    /*
     * Run time complexity:
     * O(n)
     */
    private static int sumMid(final int[] a, final int l, final int r, final int mid) {

        // go left
        int runningSum = a[mid];
        int maxLeftSum = a[mid];
        for (int i=mid-1; i>=l; i--) {
            runningSum += a[i];
            if (runningSum > maxLeftSum) {
                maxLeftSum = runningSum;
            }
        }

        // go right
        runningSum = a[mid+1];
        int maxRightSum = a[mid+1];
        for (int i=mid+2; i<=r; i++) {
            runningSum += a[i];
            if (runningSum > maxRightSum) {
                maxRightSum = runningSum;
            }
        }

        return maxLeftSum + maxRightSum;
    }
}
