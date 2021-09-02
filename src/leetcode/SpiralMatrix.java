//Given an m x n matrix, return all elements of the matrix in spiral order.

package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pradeep Arya
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        System.out.println(m + "x" + n);

        int startRow = 0;
        int endRow = m - 1;

        int startColumn = 0;
        int endColumn = n - 1;


        List<Integer> output = new ArrayList<>();


        int direction = 0;


        while (startRow <= endRow && startColumn <= endColumn) {


            if (direction == 0) {
                for (int column = startColumn; column <= endColumn; column++) {
                    output.add(matrix[startRow][column]);
                }
                startRow++;
            } else if (direction == 1) {
                for (int row = startRow; row <= endRow; row++) {
                    output.add(matrix[row][endColumn]);
                }
                endColumn--;

            } else if (direction == 2) {
                for (int column = endColumn; column >= startColumn; column--) {
                    output.add(matrix[endRow][column]);
                }
                endRow--;

            } else {
                for (int row = endRow; row >= startRow; row--) {
                    output.add(matrix[row][startColumn]);
                }
                startColumn++;

            }
            direction = (direction + 1) % 4;
        }


        return output;

    }

    public static void main(String[] args) {

        System.out.println("output [1,2,3,4,8,12,11,10,9,5,6,7] " + new SpiralMatrix().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));

    }
}
