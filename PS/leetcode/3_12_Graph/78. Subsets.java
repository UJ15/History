import java.util.*;

class Solution {
    private List<List<Integer>> answer;
    private int[] numbers;

    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        numbers = nums;

        dfs(0, new ArrayList<>());
        return answer;
    }

    private void dfs(int index, List<Integer> element) {
        answer.add(new ArrayList<>(element));

        for (int i = index ; i < numbers.length ; i++) {
            element.add(numbers[i]);
            dfs(i + 1, element);
            element.remove(element.size() - 1);
        }
    }
}