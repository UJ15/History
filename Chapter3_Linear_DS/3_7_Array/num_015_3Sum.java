class Solution {// 투 포인터 풀이 복잡도 n제곱
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        int i = 0;//i 를 축으로 움직인다.
        int left = i + 1;
        int right = nums.length - 1;
        
        Arrays.sort(nums);
        
        while (i <= right - 2){//i 축으로 left와 right가 좁혀지면서 sum이 0인 값을 검사
            if (i > 0 && nums[i] == nums[i-1]){
                i++;
                left = i + 1;//중복 처리
                continue;
            }
            while (left < right){
                if (left > i + 1 && nums[left] == nums[left - 1]){
                    left++;
                    continue;//중복 처리
                }
                else if (right < nums.length - 1 && nums[right] == nums[right + 1]){
                    right--;
                    continue;//중복 처리
                }
                sum = nums[i] + nums[left] + nums[right];
                if (sum < 0){
                    left++;
                }else if (sum > 0){
                    right--;
                }else{
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(new ArrayList<>(list));
                    list.clear();
                    left++;
                }
            }
            i++;
            left = i + 1;
            right = nums.length - 1;
        }
        return result;
    }
}
