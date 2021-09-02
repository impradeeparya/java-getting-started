//Given an n x n binary grid, in one step you can choose two adjacent rows of the grid and swap them.
//
//A grid is said to be valid if all the cells above the main diagonal are zeros.
//
//Return the minimum number of steps needed to make the grid valid, or -1 if the grid cannot be valid.
//
//The main diagonal of a grid is the diagonal that starts at cell (1, 1) and ends at cell (n, n).

package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Pradeep Arya
 */
public class MinimumSwapBinaryGrid {

//    calculate leading ones
//    public int validGrid(int[][] array) {
//        int valid = 0;
//
//        for (int row = 0; row < array.length; row++) {
//            for (int column = row + 1; column < array[row].length; column++) {
//                if (array[row][column] != 0) {
//                    valid = -1;
//                    break;
//                }
//            }
//            if (valid == -1) {
//                break;
//            }
//        }
//
//
//        return valid;
//    }
//
//    public int swap(int[][] copy, int row, int currentRow) {
//        int swapCount = 0;
//
//        for (int index = currentRow - 1; index >= row; index--) {
//            int nextRow = index + 1;
//            for (int column = 0; column < copy[0].length; column++) {
//                copy[index][column] = copy[index][column] + copy[nextRow][column];
//                copy[nextRow][column] = copy[index][column] - copy[nextRow][column];
//                copy[index][column] = copy[index][column] - copy[nextRow][column];
//            }
//            swapCount++;
//        }
//
//
//        return swapCount;
//    }
//
//    public int minSwap(int[][] array, int row, int rowCount) {
//        int distance = -1;
//
//        if (row == rowCount) {
//            return validGrid(array);
//        }
//
//        List<Integer> rows = new ArrayList<>();
//        for (int subIndex = row; subIndex < rowCount; subIndex++) {
//            if (array[subIndex][row] == 1) {
//                rows.add(subIndex);
//            }
//        }
//
//        if (rows.size() == 0) {
//            return -1;
//        }
//
//        for (Integer currentRow : rows) {
//            int[][] copy = Arrays.stream(array).map(int[]::clone).toArray(int[][]::new);
//            int swapCount = swap(copy, row, currentRow);
//            int subSwapCount = minSwap(copy, row + 1, rowCount);
//
//            if (subSwapCount != -1) {
//                swapCount += subSwapCount;
//                if (distance == -1) {
//                    distance = swapCount;
//                } else {
//                    distance = Math.min(distance, swapCount);
//                }
//            }
//
//        }
//
//        return distance;
//    }
//
//    public int minSwaps(int[][] grid) {
//        return minSwap(grid, 0, grid.length);
//    }

    //    calculate leading zeros
    public int swap(List<Integer> leadingZeros, int zeroCount, int swapIndex) {
        int swapCount = -1;

        if (swapIndex == leadingZeros.size()) {
            return 0;
        }

        int zeroIndex = -1;
        for (int index = 0; index < leadingZeros.size(); index++) {
            if (leadingZeros.get(index) == zeroCount) {
                zeroIndex = index;
                break;
            }
        }

        if (zeroIndex != -1) {
            int diff = zeroIndex - swapIndex;
            int value = leadingZeros.remove(zeroIndex);
            leadingZeros.add(swapIndex, value);
            int count = swap(leadingZeros, zeroCount - 1, swapIndex + 1);
            if (count >= 0) {
                swapCount = count + diff;
            }

        }

        return swapCount;
    }

    public int minSwaps(int[][] grid) {
        List<Integer> leadingZeros = new LinkedList<>();

        for (int row = 0; row < grid.length; row++) {
            int zeros = 0;
            for (int column = grid[row].length - 1; column >= 0; column--) {
                if (grid[row][column] == 1) {
                    break;
                }
                zeros++;
            }
            leadingZeros.add(zeros);
        }
        return swap(leadingZeros, grid[0].length - 1, 0);
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSwapBinaryGrid().minSwaps(new int[][]{{0, 0, 1}, {1, 1, 0}, {1, 0, 0}}));
        System.out.println(new MinimumSwapBinaryGrid().minSwaps(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}}));
        System.out.println(new MinimumSwapBinaryGrid().minSwaps(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 1}}));
        System.out.println(new MinimumSwapBinaryGrid().minSwaps(new int[][]{{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}}));
    }

}
