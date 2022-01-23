class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int first = 0;
        int second = 0;
        
        for (int i = 0 ; i < nums.length ; i++){
            for (int j = i + 1 ; j < nums.length ; j++){
                if (nums[i] + nums[j] == target){
                    first = i;
                    second = j;
                }
            }
        }
        
        result[0] = first;
        result[1] = second;
        return(result);
    }
}
//brute force 식 풀이 복잡도가 불량함

import java.util.HashMap;
//해쉬맵을 사용해 target에서 첫 번째 수를 뺀 값이 키갑에 존재하는지 조회
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int comp;
        int value = 0;

        for (int key : nums){
            map.put(key, value);
            value++;
        }

        for (int i = 0; i < nums.length; i++){
            comp = target - nums[i];
            if (map.containsKey(comp) && i != map.get(comp)){//자신을 조회하지 않도록 value가 인덱스니까 
                result[0] = i;
                result[1] = map.get(comp);
                break;
            }
        }

        return result;
    }
}
