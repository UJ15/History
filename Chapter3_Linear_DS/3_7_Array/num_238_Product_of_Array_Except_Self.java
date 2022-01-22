class Solution {//복잡도가 O(n)이어야 하는 조건
    public int[] productExceptSelf(int[] nums) {
        int[] result1 = new int[nums.length];
        int[] result2 = new int[nums.length];
        
        int left = 1;
        int right = 1;
        
        for (int i = 0 ; i < nums.length ; i++){//자신을 제외한 왼쪽을 곱한 배열
            if (i == 0){
                result1[i] = 1;
            }else if (i == 1){
                result1[i] = nums[i-1];
            }else{
                result1[i] = nums[i-1] * result1[i-1];
            }
        }
        
        for (int i = nums.length - 1 ; i >= 0 ; i--){//자신을 제외한 오른쪽을 곱한 배열
            if (i == nums.length - 1){
                result2[i] = 1;
            }else if (i == nums.length - 2){
                result2[i] = nums[i + 1];
            }else{
                result2[i] = nums[i+1] * result2[i+1];
            }
        }
        
        for (int i = 0; i < nums.length ; i++){//두 배열을 곱해줌
            result2[i] = result2[i] * result1[i];
        }
        
        return result2;
    }
}
