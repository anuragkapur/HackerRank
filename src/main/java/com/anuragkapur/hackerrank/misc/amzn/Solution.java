package com.anuragkapur.hackerrank.misc.amzn;

/**
 * @author anuragkapur
 */
public class Solution {

    public static void main(String[] args) {
        int length = 3;
        int width = 5;
        int[] xs = {1};
        int[] ys = {1};

        int[][] city = getLockerDistanceGrid(length, width, xs, ys);

        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city[i].length; j++) {
                System.out.print(city[i][j]);
            }
            System.out.println("");
        }
    }

    /**
     * Run time complexity
     * ===================
     *
     * Theta(cityLength * cityWidth * lockerXCoordinates)
     *
     * because for each grid element in the city, we compute its distance from each locker.
     * No. of grid points = cityLength * cityWidth
     * No of distance comparisons for each grid point = number of lockers = lockerXCoordinates
     *
     * Thus, total significant operations = cityLength * cityWidth * lockerXCoordinates
     *
     * Could we do better in terms of run time complexity?
     * No, because cityLength * cityWidth is unavoidable as that's the number of grid elements. And each element's
     * distance from each locker needs to be computed. Some local optimisations, like not computing distance from a
     * new lockers, if min distance is already 1 are possible. But this would not change the asymptotic run time.
     *
     * Space complexity
     * ================
     *
     * O(1), as it does not use any temporary data structures, whose size depends on the input size.
     */
    static int[][] getLockerDistanceGrid(int cityLength, int cityWidth, int[] lockerXCoordinates, int[] lockerYCoordinates) {

        // init city
        int[][] city = new int[cityWidth][cityLength];

        for (int row=0; row<cityWidth; row++) {
            for (int column=0; column<cityLength; column++) {

                int minDistanceFromLocker = -1;

                // for each element in grid, compute distance from each locker and pick the minimum distance
                for (int k = 0; k < lockerXCoordinates.length; k++) {
                    int x = lockerXCoordinates[k];
                    int y = lockerYCoordinates[k];

                    // compute distance of point from locker
                    int distance = Math.abs(x-column-1) + Math.abs(y-row-1);
                    
                    // update min-distance
                    if (minDistanceFromLocker == -1) {
                        minDistanceFromLocker = distance;
                    } else if (minDistanceFromLocker > distance) {
                        minDistanceFromLocker = distance;
                    }
                }
                
                city[row][column] = minDistanceFromLocker;
            }
        }
        return city;
    }
}
