import java.util.*;

class Solution {
    private int[] leverCoordinate;
    private int[] exitCoordinate;
    private int[] startCoordinate;
    private int result;
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {1, -1, 0, 0};
    private boolean escape;

    public int solution(String[] maps) {
        result = 0;
        initCoordinate(maps);
        moveToDestynation(startCoordinate, leverCoordinate, maps);

        if (!escape) {
            return -1;
        }

        moveToDestynation(leverCoordinate, exitCoordinate, maps);

        return escape ? result : -1;
    }

    private void moveToDestynation(int[] start, int[] end, String[] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {start[0], start[1], 0});
        escape = false;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int level = current[2];

            if (visited[x][y]) {
                continue;
            }

            visited[x][y] = true;

            for (int i = 0 ; i < 4 ; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (isOutOfRange(nextX, nextY, visited.length, visited[0].length)) {
                    continue;
                }

                if (nextX == end[0] && nextY == end[1]) {
                    result += level + 1;
                    escape = true;
                    return;
                }

                char c = maps[nextX].charAt(nextY);
                if (c == 'O' || c == 'L' || c == 'E' || c == 'S') {
                    q.offer(new int[] {nextX, nextY, level + 1});
                }
            }
        }
    }

    private boolean isOutOfRange(int x, int y, int n, int m) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }

    private void initCoordinate(String[] maps) {
        for (int i = 0 ; i < maps.length ; i++) {
            for (int j = 0 ; j < maps[0].length() ; j++) {
                if (maps[i].charAt(j) == 'S') {
                    startCoordinate = new int[] {i, j};
                }

                if (maps[i].charAt(j) == 'E') {
                    exitCoordinate = new int[] {i, j};
                }

                if (maps[i].charAt(j) == 'L') {
                    leverCoordinate = new int[] {i, j};
                }
            }
        }
    }
}