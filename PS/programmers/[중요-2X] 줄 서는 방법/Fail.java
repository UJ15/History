//효율성 시간 초과
import java.util.*;

class Solution {
    List<List<Integer>> list;
    long cnt;
    long k2;

    public int[] solution(int n, long k) {
        list = new ArrayList<>();
        cnt = 1;
        k2 = k;

        dfs(1, n, new ArrayList<>());
        return list.get(0).stream().mapToInt(i -> i).toArray();
    }

    private void dfs(int start, int n, List<Integer> combination) {
        if (combination.size() == n) {
            if (cnt == k2) {
                list.add(new ArrayList<>(combination));
            } else {
                cnt++;
            }

            return;
        }

        for (int i = 1 ; i <= n ; i++) {
            if (!combination.contains(i)) {
                combination.add(i);
                dfs(i, n, combination);
                combination.remove(combination.size() - 1);
            }
        }
    }
}