package leetcode;

import java.util.Arrays;

/**
 * @author Pradeep Arya
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int output = 0;

        int rowLength = matrix.length;
        if (rowLength > 0) {
            int columnLength = matrix[0].length;

            int[][] outputMatrix = new int[rowLength][columnLength];

            for (int row = 0; row < rowLength; row++) {
                int count = 0;
                for (int column = 0; column < columnLength; column++) {

                    if (matrix[row][column] == '0') {
                        count = 0;
                    } else {
                        count += 1;
                    }

                    outputMatrix[row][column] = count;

                }
            }

//            System.out.println(Arrays.deepToString(outputMatrix));

            int row = 0;
            int column = 0;

            while (row < rowLength) {

                int value = outputMatrix[row][column];

                if (value >= 1) {

                    if (value > output) {
                        output = value;
                    }

                    int rowIndex = row + 1;
                    int minValue = value;
                    while (rowIndex < rowLength) {
                        int nextValue = outputMatrix[rowIndex][column];

                        if (nextValue == 0) {
                            break;
                        }
                        minValue = Math.min(minValue, nextValue);

                        int maxValue = (rowIndex - row + 1) * minValue;

                        if (maxValue > output) {
                            output = maxValue;
                        }

                        rowIndex++;
                    }

                    int maxValue = (rowIndex - row) * minValue;

                    if (maxValue > output) {
                        output = maxValue;
                    }

                }

                column++;

                if (column == columnLength) {
                    row++;
                    column = 0;
                }

            }
        }


        return output;
    }


    public static void main(String[] args) {
        System.out.println("output 6 " + new MaximalRectangle().maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
        System.out.println("output 0 " + new MaximalRectangle().maximalRectangle(new char[][]{}));
        System.out.println("output 0 " + new MaximalRectangle().maximalRectangle(new char[][]{{'0'}}));
        System.out.println("output 1 " + new MaximalRectangle().maximalRectangle(new char[][]{{'1'}}));
        System.out.println("output 0 " + new MaximalRectangle().maximalRectangle(new char[][]{{'0', '0'}}));
        System.out.println("output 8 " + new MaximalRectangle().maximalRectangle(new char[][]{{'1', '0', '1', '1', '0', '1'}, {'1', '1', '1', '1', '1', '1'}, {'0', '1', '1', '0', '1', '1'}, {'1', '1', '1', '0', '1', '0'}, {'0', '1', '1', '1', '1', '1'}, {'1', '1', '0', '1', '1', '1'}}));
        System.out.println("output 10 " + new MaximalRectangle().maximalRectangle(new char[][]{{'0', '1', '1', '0', '0', '1', '0', '1', '0', '1'}, {'0', '0', '1', '0', '1', '0', '1', '0', '1', '0'}, {'1', '0', '0', '0', '0', '1', '0', '1', '1', '0'}, {'0', '1', '1', '1', '1', '1', '1', '0', '1', '0'}, {'0', '0', '1', '1', '1', '1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0', '1', '1', '1', '1', '0'}, {'0', '0', '0', '1', '1', '0', '0', '0', '1', '0'}, {'1', '1', '0', '1', '1', '0', '0', '1', '1', '1'}, {'0', '1', '0', '1', '1', '0', '1', '0', '1', '1'}}));
        System.out.println("output 6 " + new MaximalRectangle().maximalRectangle(new char[][]{
                {'0', '0', '0', '1', '0', '1', '0'},
                {'0', '1', '0', '0', '0', '0', '0'},
                {'0', '1', '0', '1', '0', '0', '1'},
                {'0', '0', '1', '1', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '1', '0'},
                {'1', '0', '0', '1', '0', '1', '1'},
                {'0', '1', '0', '0', '1', '0', '1'},
                {'1', '1', '0', '1', '1', '1', '0'},
                {'1', '0', '1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '0', '0', '0'}}));
    }
}
