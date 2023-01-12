https://school.programmers.co.kr/learn/courses/30/lessons/87946

class Solution {
    private int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];

        dfs(0, dungeons, visited, k);

        return answer;
    }

    private void dfs(int depth, int[][] dungeons, boolean[] visited, int k) {
        if (k <= 0 || depth == dungeons.length) {
            answer = Math.max(answer, depth);
            return;
        }

        for (int i = 0 ; i < dungeons.length ; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(depth + 1, dungeons, visited, k - dungeons[i][1]);
                visited[i] = false;
            }
        }

        answer = Math.max(answer, depth);
    }
}