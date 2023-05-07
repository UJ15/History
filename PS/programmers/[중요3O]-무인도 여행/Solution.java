import java.util.*;

class Solution {
    int[][] map;
    boolean[][] visited;

    public int[] solution(String[] maps) {
        List<Integer> result = new ArrayList<>();
        map = new int[maps.length][maps[0].length()];
        visited = new boolean[map.length][map[0].length];

        for (int i = 0 ; i < maps.length ; i++) {
            String s = maps[i];
            for (int j = 0 ; j < s.length() ; j++) {
                char c = s.charAt(j);
                if (c == 'X') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = c - '0';
                }
            }
        }

        for (int i = 0 ; i < map.length ; i++) {
            for (int j = 0 ; j < map[0].length ; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    bfs(new int[] {i, j}, result);
                }
            }
        }

        if (result.isEmpty()) {
            result.add(-1);
        }

        return result.stream().sorted().mapToInt(i -> i).toArray();
    }

    private void bfs(int[] start, List<Integer> result) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int count = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            count += map[cur[0]][cur[1]];

            for (int i = 0 ; i < 4 ; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX == map.length || nextY == map[0].length) {
                    continue;
                }

                if (!visited[nextX][nextY] && map[nextX][nextY] > 0) {
                    visited[nextX][nextY] = true;
                    q.offer(new int[] {nextX, nextY});
                }
            }
        }

        result.add(count);
    }
}