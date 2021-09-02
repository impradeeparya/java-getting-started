//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
//
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

package leetcode;

/**
 * @author Pradeep Arya
 */
public class NumberOfIslands {

    private void traverseIsland(char[][] grid, int row, int column, int[][] directions, int rows, int columns) {

        if (row >= rows || row < 0 || column >= columns || column < 0 || grid[row][column] == '0') {
            return;
        }
        grid[row][column] = '0';
        traverseIsland(grid, row + directions[0][0], column + directions[0][1], directions, rows, columns);
        traverseIsland(grid, row + directions[1][0], column + directions[1][1], directions, rows, columns);
        traverseIsland(grid, row + directions[2][0], column + directions[2][1], directions, rows, columns);
        traverseIsland(grid, row + directions[3][0], column + directions[3][1], directions, rows, columns);

    }

    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == '1') {
                    numberOfIslands++;
                    traverseIsland(grid, row, column, directions, rows, columns);
                }
            }
        }


        return numberOfIslands;
    }


    public static void main(String[] args) {
        System.out.println("output 1 " + new NumberOfIslands().numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
        System.out.println("output 3 " + new NumberOfIslands().numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }
}
