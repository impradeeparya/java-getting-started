//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//A subarray is a contiguous part of an array.

package leetcode;

/**
 * @author Pradeep Arya
 */
public class MaximumSubarray {
//    public int maxSubArray(int[] nums) {
//        int max = nums[0];
//        int length = nums.length;
//        int[][] memory = new int[length][length];
//
//        for (int index = 0; index < length; index++) {
//            memory[index][index] = nums[index];
//        }
//
//        for (int index = 1; index < length; index++) {
//            memory[0][index] = nums[index] + memory[0][index - 1];
//            if (max < nums[index]) {
//                max = nums[index];
//            }
//            if (max < memory[0][index]) {
//                max = memory[0][index];
//            }
//        }
//        for (int rowIndex = 1; rowIndex < length; rowIndex++) {
//            for (int columnIndex = rowIndex + 1; columnIndex < length; columnIndex++) {
//                memory[rowIndex][columnIndex] = memory[rowIndex][columnIndex - 1] + memory[rowIndex - 1][columnIndex] - memory[rowIndex - 1][columnIndex - 1];
//                if (max < memory[rowIndex][columnIndex]) {
//                    max = memory[rowIndex][columnIndex];
//                }
//                if (max < memory[rowIndex][columnIndex]) {
//                    max = memory[rowIndex][columnIndex];
//                }
//            }
//        }
//
//        return max;
//    }

//    public int maxSubArray(int[] nums) {
//        int max = nums[0];
//        int length = nums.length;
//        int[] memory = new int[length];
//        memory[0] = nums[0];
//
//        for (int index = 1; index < length; index++) {
//            memory[index] = nums[index] + memory[index - 1];
//            if (max < nums[index]) {
//                max = nums[index];
//            }
//            if (max < memory[index]) {
//                max = memory[index];
//            }
//        }
//        for (int rowIndex = 1; rowIndex < length; rowIndex++) {
//            int[] temp = new int[length];
//            temp[rowIndex] = nums[rowIndex];
//            for (int columnIndex = rowIndex + 1; columnIndex < length; columnIndex++) {
//                temp[columnIndex] = temp[columnIndex - 1] + memory[columnIndex] - memory[columnIndex - 1];
//                if (max < temp[columnIndex]) {
//                    max = temp[columnIndex];
//                }
//            }
//            memory = temp;
//        }
//
//        return max;
//    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int length = nums.length;
        int[] memory = new int[length];
        memory[0] = nums[0];

        for (int index = 1; index < length; index++) {
            for (int subIndex = 0; subIndex <= index; subIndex++) {
                if (nums[subIndex] > max) {
                    max = nums[subIndex];
                }

                memory[subIndex] = memory[subIndex] + nums[index];
                if (memory[subIndex] > max) {
                    max = memory[subIndex];
                }
            }
        }

        return max;
    }


    public static void main(String[] args) {
        System.out.println("output 6 " + new MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println("output 1 " + new MaximumSubarray().maxSubArray(new int[]{-2, 1}));
        System.out.println("output 4 " + new MaximumSubarray().maxSubArray(new int[]{-1, 1, 2, 1}));
        System.out.println("output -1 " + new MaximumSubarray().maxSubArray(new int[]{-2, -1}));
    }
}
