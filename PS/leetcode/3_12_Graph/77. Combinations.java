import java.util.*;

class Solution {
    private List<List<Integer>> answer;

    public List<List<Integer>> combine(int n, int k) {
        answer = new ArrayList<>();
        combination(1, n, k, new ArrayList<>());

        return answer;
    }

    private void combination(int start, int n, int k, List<Integer> element) {
        if (element.size() == k) {
            answer.add(new ArrayList<>(element));
            return;
        }

        for (int i = start ; i <= n ; i++) {
            element.add(i);
            combination(i + 1, n, k, element);
            element.remove(Integer.valueOf(i));
        }
    }
}