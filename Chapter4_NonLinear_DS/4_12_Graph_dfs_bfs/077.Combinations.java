import java.util.ArrayList;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        
        dfs(n, k, 1, temp, result);
        
        return result;
    }
    
    public void dfs(int n, int k, int start, List<Integer> temp, List<List<Integer>> result){
        if (temp.size() == k){
            result.add(new ArrayList<Integer>(temp));
            return ;
        }
        
        for (int i = start ; i <= n ; i++){
            temp.add(i);                    //start 부터 하나씩 증가 시키면서 재귀
            dfs(n, k, i + 1, temp, result);
            temp.remove(temp.size() - 1);//백트래킹
        }
    }
}
