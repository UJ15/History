class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }

        int result = 0;
        int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
        int[] dy = {0, 0, -1, 1, 1, -1, -1, 1};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        q.offer(new int[] {0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            //0,0 하나의 원소만 있을때
            if (cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1) {
                return cur[2];
            }

            for (int i = 0 ; i < 8 ; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if (isOutOfRange(nextX, nextY, grid) || visited[nextX][nextY] || grid[nextX][nextY] == 1){
                    continue;
                }

                if (nextX == grid.length - 1 && nextY == grid[0].length - 1) {
                    return cur[2] + 1;
                }

                visited[nextX][nextY] = true;
                q.offer(new int[] {nextX, nextY, cur[2] + 1});
            }
        }

        return -1;
    }

    private boolean isOutOfRange(int x, int y, int[][] grid) {
        return x < 0 || y < 0 || x >= grid.length || y >= grid[0].length;
    }
}