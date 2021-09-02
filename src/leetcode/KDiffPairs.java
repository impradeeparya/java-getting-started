//Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
//
//A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
//
//0 <= i < j < nums.length
//|nums[i] - nums[j]| == k
//Notice that |val| denotes the absolute value of val.

package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pradeep Arya
 */
public class KDiffPairs {

    public int findPairs(int[] nums, int k) {

        Map<Integer, Integer> frequencies = new HashMap<>();
        Arrays.stream(nums).forEach(number -> frequencies.merge(number, 1, Integer::sum));
//        System.out.println(frequencies);
        return Arrays.stream(nums).map(number -> {
            int pairCount;
            if (frequencies.getOrDefault(number, 0) > 0) {
                if (k == 0) {
                    int count = frequencies.get(number) > 1 ? 1 : 0;
                    pairCount = count;
                    frequencies.put(number, 1);
                } else {
                    pairCount = (frequencies.getOrDefault(number - k, 0) > 0 ? 1 : 0) + (frequencies.getOrDefault(number + k, 0) > 0 ? 1 : 0);
                    frequencies.remove(number);
                }
//                System.out.println(frequencies + " " + pairCount + " " + number + " " + (number - k) + "" + (number + k));
            } else {
                pairCount = 0;
            }
            return pairCount;
        }).sum();

    }

    public static void main(String[] args) {

        System.out.println("output 2 " + new KDiffPairs().findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println("output 4 " + new KDiffPairs().findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println("output 1 " + new KDiffPairs().findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        System.out.println("output 2 " + new KDiffPairs().findPairs(new int[]{1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3));
        System.out.println("output 2 " + new KDiffPairs().findPairs(new int[]{-1, -2, -3}, 1));
    }
}
