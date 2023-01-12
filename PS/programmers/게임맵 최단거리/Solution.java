https://school.programmers.co.kr/learn/courses/30/lessons/1844

import java.util.*;

class Solution {

    private final int dx[] = {-1, 0, 1, 0};
    private final int dy[] = {0, -1, 0, 1};

    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];

        bfs(maps, visited);
        answer = visited[maps.length - 1][maps[0].length - 1];

        if (answer == 0) {
            return -1;
        }

        return answer;
    }

    private void bfs(int[][] maps, int[][] visited) {
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0 ; i < 4 ; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx > maps.length - 1 || ny < 0 || ny > maps[0].length - 1) {
                    continue;
                }

                if (maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[cx][cy] + 1;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }
}