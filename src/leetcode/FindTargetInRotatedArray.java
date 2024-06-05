package leetcode;

public class FindTargetInRotatedArray {
    private int search(int[] nums, int target, int startIndex, int endIndex) {
        // System.out.println(startIndex + " " + endIndex);
        if (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if(nums[startIndex] <= nums[mid]){

                if(target >= nums[startIndex] && target <= nums[mid]){
                    return search(nums, target, startIndex, mid - 1);
                }

                return search(nums, target, mid + 1, endIndex);

            }

            if(target >= nums[mid] && target <= nums[endIndex]){
                return search(nums, target, mid + 1, endIndex);
            }
            return search(nums, target, startIndex, mid - 1);
        }

        return -1;

    }

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);

    }

    public static void main(String[] args) {
        System.out.println(new FindTargetInRotatedArray().search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(new FindTargetInRotatedArray().search(new int[]{5, 7, 7, 8, 8, 10}, 6));
        System.out.println(new FindTargetInRotatedArray().search(new int[]{}, 0));
    }
}
