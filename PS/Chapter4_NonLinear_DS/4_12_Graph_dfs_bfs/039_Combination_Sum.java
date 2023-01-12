import java.util.ArrayList;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        dfs(0,0, candidates, target, temp, result);
        
        return result;
    }
    
    public void dfs(int csum,int index, int[] candidates, int target, List<Integer> temp, List<List<Integer>> result){
        if (target - csum < 0){//csum을 활용해서 타겟인지 확인
            return ;
        }
        if (target - csum == 0){
            result.add(new ArrayList<Integer>(temp));
            return ;
        }
        
        for (int i = index; i < candidates.length ; i++){
            temp.add(candidates[i]);
            csum += candidates[i];
            dfs(csum, i, candidates, target, temp, result);
            temp.remove(temp.size() - 1);
            csum -= candidates[i];
        }
    }
}
