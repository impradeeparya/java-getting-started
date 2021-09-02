package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Pradeep Arya
 */
public class LargestIsland {

    class Node {
        int x;
        int y;
        int val;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getVal() {
            return val;
        }
    }

    private int traverseIsland(int[][] grid, int maxRow, int maxColumn, List<Node> queue) {
        if (queue.isEmpty()) {
            return 0;
        }

        List<Node> chileNodes = new ArrayList<>();
        for (Node node : queue) {
            int nodeX = node.getX();
            int nodeY = node.getY();
            if ((nodeY - 1 >= 0 && nodeY - 1 < maxColumn) && (grid[nodeX][nodeY - 1] == 1)) {
                chileNodes.add(new Node(nodeX, nodeY - 1, grid[nodeX][nodeY - 1]));
                grid[nodeX][nodeY - 1] = -1;
            }

            if ((nodeY + 1 >= 0 && nodeY + 1 < maxColumn) && (grid[nodeX][nodeY + 1] == 1)) {
                chileNodes.add(new Node(nodeX, nodeY + 1, grid[nodeX][nodeY + 1]));
                grid[nodeX][nodeY + 1] = -1;
            }

            if ((nodeX - 1 >= 0 && nodeX - 1 < maxRow) && (grid[nodeX - 1][nodeY] == 1)) {
                chileNodes.add(new Node(nodeX - 1, nodeY, grid[nodeX - 1][nodeY]));
                grid[nodeX - 1][nodeY] = -1;
            }

            if ((nodeX + 1 >= 0 && nodeX + 1 < maxRow) && (grid[nodeX + 1][nodeY] == 1)) {
                chileNodes.add(new Node(nodeX + 1, nodeY, grid[nodeX + 1][nodeY]));
                grid[nodeX + 1][nodeY] = -1;
            }
        }

        int childSum = traverseIsland(grid, maxRow, maxColumn, chileNodes);
        for (Node node : chileNodes) {
            int nodeX = node.getX();
            int nodeY = node.getY();
            grid[nodeX][nodeY] = node.getVal();
        }
        return queue.size() + childSum;
    }

    public int largestIsland(int[][] grid) {

        int maxLength = 0;

        int maxRow = grid.length;
        int maxColumn = grid[0].length;

        boolean isZeroFound = false;
        List<Node> nodes = new ArrayList<>();
        for (int row = 0; row < maxRow; row++) {
            for (int column = 0; column < maxColumn; column++) {
                if (grid[row][column] == 0) {
                    nodes.add(new Node(row, column, grid[row][column]));
                    grid[row][column] = -1;
                    maxLength = Math.max(traverseIsland(grid, maxRow, maxColumn, nodes), maxLength);
                    grid[row][column] = 0;
                    nodes.clear();
                    isZeroFound = true;
                }
            }
        }

        if (!isZeroFound) {
            maxLength = maxRow * maxColumn;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("output 3 " + new LargestIsland().largestIsland(new int[][]{{1, 0}, {0, 1}}));
        System.out.println("output 4 " + new LargestIsland().largestIsland(new int[][]{{1, 1}, {1, 0}}));
        System.out.println("output 4 " + new LargestIsland().largestIsland(new int[][]{{1, 1}, {1, 1}}));
    }
}
