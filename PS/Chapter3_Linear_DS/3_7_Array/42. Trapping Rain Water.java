//
//
//class Solution {
//    public int trap(int[] height) {
//        int water = 0;
//        int left = 0;
//        int right = height.length - 1;
//
//        int leftHigh = height[left];
//        int rightHigh = height[right];
//
//        while (left < right) {
//            leftHigh = Math.max(leftHigh, height[left]);
//            rightHigh = Math.max(rightHigh, height[right]);
//
//            if (leftHigh < rightHigh) {
//                water += leftHigh - height[left];
//                left++;
//            } else {
//                water += rightHigh - height[right];
//                right--;
//            }
//        }
//
//        return water;
//    }
//}