import java.util.ArrayList;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        boolean[] flag = new boolean[nums.length];
        dfs(nums, temp, flag, result);
        return result;
    }
    
    public void dfs(int[] nums, List<Integer> temp, boolean[] flag, List<List<Integer>> result){
        if (temp.size() == nums.length) result.add(new ArrayList<>(temp));
        else {
            for (int i = 0 ; i < nums.length ; i++){
                if (!flag[i]){
                    temp.add(nums[i]);
                    flag[i] = true;
                    dfs(nums, temp, flag, result);
                    temp.remove(temp.size() - 1);
                    flag[i] = false;
                }
            }
        }
    }
}
