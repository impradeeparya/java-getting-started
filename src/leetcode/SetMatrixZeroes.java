package leetcode;

import java.util.Set;

/**
 * @author Pradeep Arya
 */
public class SetMatrixZeroes {

    public void setRow(int[][] matrix, Set<Integer> rowIndexes, int columns) {

        for (Integer rowIndex : rowIndexes) {
            for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
                int value = matrix[rowIndex][columnIndex];
                if (value != 0) {
                    matrix[rowIndex][columnIndex] = 0;
                }
            }
        }

    }

    public void setColumn(int[][] matrix, Set<Integer> columnIndexes, int rows) {
        for (Integer columnIndex : columnIndexes) {
            for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
                int value = matrix[rowIndex][columnIndex];
                if (value != 0) {
                    matrix[rowIndex][columnIndex] = 0;
                }
            }
        }
    }

    public int[][] setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;
        int rowIndexes = 0;
        int columnIndexes = 0;
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columns; columnIndex++) {

                if (matrix[rowIndex][columnIndex] == 0) {
                    rowIndexes = rowIndexes | (1 << rowIndex);
                    columnIndexes = columnIndexes | (1 << columnIndex);
                }

            }
        }
        System.out.println(rowIndexes + " " + columnIndexes);
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columns; columnIndex++) {

                boolean isRowZero = (rowIndexes & (1 << rowIndex)) != 0;
                boolean isColumnZero = (columnIndexes & (1 << columnIndex)) != 0;
                if(isRowZero || isColumnZero){
                    matrix[rowIndex][columnIndex] = 0;
                }

            }
        }
        return matrix;
    }


    private static void print(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columns; columnIndex++) {

                System.out.print(matrix[rowIndex][columnIndex] + " ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(new SetMatrixZeroes().setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}}));
    }
}
