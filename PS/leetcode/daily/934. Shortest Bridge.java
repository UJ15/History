class Solution {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private int result;
    private int[][] map;

    public int shortestBridge(int[][] grid) {
        result = Integer.MAX_VALUE;
        map = grid;

        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[0].length ; j++) {
                if (grid[i][j] == 1) {
                    bfs(i, j);
                    bfs2(i, j);
                    return result;
                }
            }

        }

        return result;
    }

    private void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        map[i][j] = -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int m = 0 ; m < 4 ; m++) {
                int nextX = cur[0] + dx[m];
                int nextY = cur[1] + dy[m];

                if (isOutOfRange(nextX, nextY)) {
                    continue;
                }

                if (map[nextX][nextY] == 1) {
                    map[nextX][nextY] = -1;
                    q.offer(new int[] {nextX, nextY});
                }
            }
        }
    }

    private void bfs2(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j, -1});
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int m = 0 ; m < 4 ; m++) {
                int nextX = cur[0] + dx[m];
                int nextY = cur[1] + dy[m];

                if (isOutOfRange(nextX, nextY)) {
                    continue;
                }

                if (map[cur[0]][cur[1]] == -1 && map[nextX][nextY] == -1 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    q.offer(new int[] {nextX, nextY, cur[2]});
                } else if (map[nextX][nextY] == 0 || cur[2] - 1 > map[nextX][nextY]) {
                    map[nextX][nextY] = cur[2] - 1;
                    q.offer(new int[] {nextX, nextY, cur[2] - 1});
                } else if (map[nextX][nextY] == 1) {
                    result = Math.min(result, Math.abs(cur[2]) - 1);
                }
            }
        }
    }

    private boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x == map.length || y == map[0].length;
    }
}