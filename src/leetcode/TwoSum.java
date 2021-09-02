//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.

package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pradeep Arya
 */
public class TwoSum {

//    public int[] twoSum(int[] nums, int target) {
//        int[] output = new int[2];
//        for (int index = 0; index < nums.length; index++) {
//            for (int subIndex = index + 1; subIndex < nums.length; subIndex++) {
//                if (nums[index] + nums[subIndex] == target) {
//                    output[0] = index;
//                    output[1] = subIndex;
//                    return output;
//                }
//            }
//        }
//
//        return output;
//    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberIndexMap = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            int number = nums[index];
            Integer subIndex = numberIndexMap.get(target - number);
            if (subIndex != null && subIndex != index) {
                return new int[]{index, subIndex};
            }
            numberIndexMap.put(number, index);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println("output [0, 1] " + Arrays.toString(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("output [1, 2] " + Arrays.toString(new TwoSum().twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println("output [0, 1] " + Arrays.toString(new TwoSum().twoSum(new int[]{3, 3}, 6)));
    }
}
