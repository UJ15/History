class Solution {
    private List<List<Integer>> answer;
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        visited = new boolean[nums.length];

        dfs(new ArrayList<>(), nums);

        return answer;
    }

    private void dfs(List<Integer> element, int[] nums) {
        if (element.size() == nums.length) {
            answer.add(new ArrayList<>(element));
            return;
        }

        for (int i = 0 ; i < nums.length ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                element.add(nums[i]);
                dfs(element, nums);
                element.remove(Integer.valueOf(nums[i]));
                visited[i] = false;
            }
        }
    }
}