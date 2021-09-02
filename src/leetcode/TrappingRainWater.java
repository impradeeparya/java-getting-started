//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
package leetcode;

/**
 * @author Pradeep Arya
 */
public class TrappingRainWater {

//    public int trap(int[] height) {
//
//        int trappedWater = 0;
//        int length = height.length;
//
//        if(length > 1) {
//            int[] leftMaximum = new int[length];
//            int[] rightMaximum = new int[length];
//
//            int max = height[0];
//            leftMaximum[0] = max;
//            for (int index = 1; index < length; index++) {
//                int currentHeight = height[index];
//                if (currentHeight > max) {
//                    max = currentHeight;
//                }
//                leftMaximum[index] = max;
//            }
//
//            max = height[length - 1];
//            rightMaximum[length - 1] = max;
//            for (int index = length - 2; index >= 0; index--) {
//                int currentHeight = height[index];
//                if (currentHeight > max) {
//                    max = currentHeight;
//                }
//                rightMaximum[index] = max;
//            }
//
//            System.out.println(Arrays.toString(leftMaximum) + " " + Arrays.toString(rightMaximum));
//
//            for (int index = 0; index < length; index++) {
//                int leftMax = leftMaximum[index];
//                int rightMax = rightMaximum[index];
//
//                trappedWater += (Math.min(leftMax, rightMax) - height[index]);
//            }
//        }
//
//
//        return trappedWater;
//
//    }

    public int trap(int[] height) {

        int trappedWater = 0;
        int length = height.length;

        if (length > 1) {

            int leftIndex = 0;
            int rightIndex = length - 1;

            int leftMax = height[leftIndex];
            int rightMax = height[rightIndex];

            while (leftIndex < rightIndex) {

                int leftValue = height[leftIndex];
                int rightValue = height[rightIndex];

                if (leftValue < rightValue) {
                    if (leftValue > leftMax) {
                        leftMax = leftValue;
                    }
                    trappedWater += (leftMax - leftValue);
                    leftIndex++;
                } else {
                    if (rightValue > rightMax) {
                        rightMax = rightValue;
                    }
                    trappedWater += (rightMax - rightValue);
                    rightIndex--;
                }
            }
        }
        return trappedWater;

    }

    public static void main(String[] args) {
        System.out.println("output 6 " + new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println("output 9 " + new TrappingRainWater().trap(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println("output 0 " + new TrappingRainWater().trap(new int[]{}));
    }
}
