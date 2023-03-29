import java.util.*;

class Solution {
    private List<List<Integer>> answer;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();

        combination(0, candidates, target, new ArrayList<>());
        return answer;
    }

    private void combination(int start, int[] candidates, int target, List<Integer> element) {
        if (target <= 0) {
            if (target == 0) {
                answer.add(new ArrayList<>(element));
            }
            return;
        }

        for (int i = start ; i < candidates.length ; i++) {
            element.add(candidates[i]);
            combination(i, candidates, target - candidates[i], element);
            element.remove(element.size() - 1);
        }
    }
}