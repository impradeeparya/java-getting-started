//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

package leetcode;

import java.util.Arrays;

/**
 * @author Pradeep Arya
 */
public class MergeIntervals {

    private boolean isOverlapped(int[] currentInterval, int[] prevInterval) {
        return !((currentInterval[0] > prevInterval[1])
                || (prevInterval[0] > currentInterval[1]));
    }

    private int updatePreviousIntervals(int[][] output, int outputIndex) {

        while (outputIndex - 1 >= 0) {
            int[] currentInterval = output[outputIndex];
            int[] prevInterval = output[outputIndex - 1];

            if (isOverlapped(currentInterval, prevInterval)) {
                prevInterval[0] = Math.min(prevInterval[0], currentInterval[0]);
                prevInterval[1] = Math.max(prevInterval[1], currentInterval[1]);
                outputIndex--;
            } else {
                break;
            }
        }


        return outputIndex;
    }

//    public int[][] merge(int[][] intervals) {
//        int length = intervals.length;
//        int[][] output = new int[length][2];
//        int outputIndex = -1;
//        for (int index = 0; index < length; index++) {
//
//            if (outputIndex == -1) {
//                outputIndex++;
//                output[outputIndex] = intervals[index];
//            } else {
//                int[] currentInterval = intervals[index];
//                int[] prevInterval = output[outputIndex];
//                if (isOverlapped(currentInterval, prevInterval)) {
//                    prevInterval[0] = Math.min(prevInterval[0], currentInterval[0]);
//                    prevInterval[1] = Math.max(prevInterval[1], currentInterval[1]);
//                    outputIndex = updatePreviousIntervals(output, outputIndex);
//                } else {
//                    outputIndex++;
//                    output[outputIndex] = currentInterval;
//                }
//            }
//
//        }
//
//        return Arrays.copyOf(output, outputIndex + 1);
//    }

    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        int newLength = length;
        for (int index = 0; index < length; index++) {
            int[] prevInterval = intervals[index];
            for (int subIndex = index + 1; subIndex < length; subIndex++) {
                int[] nextInterval = intervals[subIndex];

                if (isOverlapped(nextInterval, prevInterval)) {

                    nextInterval[0] = Math.min(prevInterval[0], nextInterval[0]);
                    nextInterval[1] = Math.max(prevInterval[1], nextInterval[1]);
                    prevInterval[0] = -1;
                    prevInterval[1] = -1;
                    newLength--;
                    break;
                }
            }

        }

        int[][] output = new int[newLength][2];
        int outputIndex = 0;
        for (int index = 0; index < length; index++) {
            int[] interval = intervals[index];

            if (interval[0] != -1 && interval[1] != -1) {
                output[outputIndex++] = interval;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println("output {{1,6},{8,10},{15,18}} " + Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println("output {{1,5}} " + Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println("output {{0,0},{1,4}} " + Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 4}, {0, 0}})));
        System.out.println("output {{1,10}} " + Arrays.deepToString(new MergeIntervals().merge(new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}})));
        System.out.println("output {{2,4},{5,5}} " + Arrays.deepToString(new MergeIntervals().merge(new int[][]{{2, 3}, {5, 5}, {2, 2}, {3, 4}, {3, 4}})));
    }
}
