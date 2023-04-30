class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}

//더 빠른 풀이
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;

        for (int num : nums) {
            map.put(num, index);
            index++;
        }

        for (int i = 0 ; i < nums.length ; i++) {
            int t = target - nums[i];

            if (map.containsKey(t) && map.get(t) != i) {
                return new int[] {i, map.get(t)};
            }
        }

        return null;
    }
}
