https://leetcode.com/problems/permutations/

import java.util.*;

class Solution {
    private List<List<Integer>> answer;
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        int[] numbers = new int[nums.length];
        visited = new boolean[nums.length];

        dfs(0, nums, numbers);

        return answer;
    }

    private void dfs(int depth, int[] nums, int[] numbers) {
        if (depth == nums.length) {
            List<Integer> list = new ArrayList<>();

            for (int number : numbers) {
                list.add(number);
            }
            answer.add(list);
            return;
        }

        for (int i = 0 ; i < nums.length ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                numbers[depth] = nums[i];
                dfs(depth + 1, nums, numbers);
                visited[i] = false;
            }
        }
    }
}