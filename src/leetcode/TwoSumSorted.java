package leetcode;

import java.util.Arrays;

/**
 * @author Pradeep Arya
 */
public class TwoSumSorted {

    public int[] twoSum(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println("output [1, 2] " + Arrays.toString(new TwoSumSorted().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("output [1, 3] " + Arrays.toString(new TwoSumSorted().twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println("output [1, 2] " + Arrays.toString(new TwoSumSorted().twoSum(new int[]{-1, 0}, -1)));
    }
}
