import java.util.ArrayList;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        
        dfs(0, nums, temp, result);
        return result;
    }
    
    public void dfs(int index, int[] nums, List<Integer> temp, List<List<Integer>> result){
        result.add(new ArrayList<Integer>(temp));
        
        for (int i = index ; i < nums.length ; i++){
            temp.add(nums[i]);
            dfs(i + 1, nums, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
