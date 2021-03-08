//Dhrumil Patel
//ArrayMaxMin
//June 16, 2020
//ICS4U1

import java.io.*;
import java.util.ArrayList;

class ColSums {

    public static void main(String[] args) {
        int[][] data = { { 3, 2, 5 }, { 1, 4, 4, 8, 13 }, { 9, 1, 0, 2 }, { 0, 2, 6, 3, -1, -8 } };
        // Use the prefix sum array approach because we are clever
        ArrayList<Integer> psums = new ArrayList<Integer>(); // Also because dynamic arrays - would make this a
                                                             // linked list if arraylist already isn't a linkedlist
                                                             // But pointers in langs other than Cpp or even C are
                                                             // harder to use...

        // compute the sums for each row
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                if (col >= psums.size()) {
                    psums.add(data[row][col]);
                } else {
                    psums.set(col, psums.get(col) + data[row][col]);
                }
            }
        }
        System.out.println("Sums of each column, from left to right");
        System.out.print(psums.toString());

    }
}