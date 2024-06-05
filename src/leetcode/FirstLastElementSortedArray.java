package leetcode;

/*34. Find First and Last Position of Element in Sorted Array*/

import java.util.Arrays;

public class FirstLastElementSortedArray {

    private void search(int[] nums, int target, int[] indexes, int startIndex, int endIndex) {
        //System.out.println(startIndex + " " + endIndex);
        if (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (nums[mid] == target) {
                if (indexes[0] == -1 && indexes[1] == -1) {
                    indexes[0] = mid;
                    indexes[1] = mid;
                } else if (indexes[0] > mid) {
                    indexes[0] = mid;
                } else if (indexes[1] < mid) {
                    indexes[1] = mid;
                }
                //System.out.println(indexes[0] + "-" + indexes[1]);
                search(nums, target, indexes, mid + 1, endIndex);
                search(nums, target, indexes, startIndex, mid - 1);
            } else if (nums[mid] < target) {
                search(nums, target, indexes, mid + 1, endIndex);
            } else {
                search(nums, target, indexes, startIndex, mid - 1);
            }
        }

    }

    public int[] searchRange(int[] nums, int target) {

        int[] output = {-1, -1};

        search(nums, target, output, 0, nums.length - 1);
        return output;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FirstLastElementSortedArray().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new FirstLastElementSortedArray().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(new FirstLastElementSortedArray().searchRange(new int[]{}, 0)));
    }
}
