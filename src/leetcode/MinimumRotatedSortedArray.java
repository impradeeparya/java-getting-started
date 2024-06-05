package leetcode;

//153. Find Minimum in Rotated Sorted Array
/*Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

        [4,5,6,7,0,1,2] if it was rotated 4 times.
        [0,1,2,4,5,6,7] if it was rotated 7 times.
        Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

        Given the sorted rotated array nums of unique elements, return the minimum element of this array.

        You must write an algorithm that runs in O(log n) time.*/

public class MinimumRotatedSortedArray {

    private int search(int[] nums, int min, int startIndex, int endIndex) {
        // System.out.println(startIndex + " " + endIndex);

        if (startIndex == endIndex) {
            min = Math.min(min, nums[startIndex]);
        } else if (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[startIndex] <= nums[mid]) {
                min = Math.min(min, nums[startIndex]);
                min = search(nums, min, mid + 1, endIndex);
            } else {
                return search(nums, min, startIndex, mid - 1);
            }
        }

        return min;

    }

    public int findMin(int[] nums) {
        return search(nums, nums[0], 0, nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new MinimumRotatedSortedArray().findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new MinimumRotatedSortedArray().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(new MinimumRotatedSortedArray().findMin(new int[]{11, 13, 15, 17}));
    }
}
