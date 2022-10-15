https://school.programmers.co.kr/learn/courses/30/lessons/43162

import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;

        for (int i = 0 ; i < n ; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, computers, n);
            }
        }

        return answer;
    }

    private void dfs(int index, int[][] computers, int n) {
        visited[index] = true;

        for (int i = 0 ; i < n ; i++) {
            if (!visited[i] && computers[index][i] == 1) {
                dfs(i, computers, n);
            }
        }
    }
}