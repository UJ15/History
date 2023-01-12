//투 포인터 풀이
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        
        int left_max = height[left];
        int right_max = height[right];
        
        while (left < right){
            left_max = Math.max(left_max, height[left]);
	    //왼쪽 가장 높은 기둥(현재 기둥과 비교해서)
            right_max = Math.max(right_max, height[right]);
	    //오른쪽 가장 높은 기둥
            
            if (left_max <= right_max){
                result += left_max - height[left];
                left++;
            }
            else{
                result += right_max - height[right];
                right--;
            }
	    //만날 때 까지 가장 높은 기둥과 현재 기둥의 차이를 추가
        }
        
        return result;
    }
}
