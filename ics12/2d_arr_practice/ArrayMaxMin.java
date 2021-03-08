//Dhrumil Patel
//ArrayMaxMin
//June 16, 2020
//ICS4U1

import java.io.*;
import java.lang.Math;

class ArrayMaxMin {

    public static void main(String[] args) {
        int[][] data = { { 3, 2, 5 }, { 1, 4, 4, 8, 13 }, { 9, 1, 0, 2 }, { 0, 2, 6, 3, -1, -8 } };

        // declare and initialize the max and the min
        int big = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                small = Math.min(data[row][col], small);
                big = Math.max(data[row][col], big);
            }
        }

        // write out the results
        System.out.println("max = " + big + "; min = " + small);

    }
}