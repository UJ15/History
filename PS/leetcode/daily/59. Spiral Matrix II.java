/**
 *
 * Spiral Matrix 1과 거의 똑같다.
 */

class Solution {
    private int[][] map;
    private boolean[][] visited;
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};

    public int[][] generateMatrix(int n) {
        map = new int[n][n];
        visited = new boolean[n][n];

        bfs(n);

        return map;
    }

    private void bfs(int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        //visited[0][0] = true;

        int i = 1;
        int direction = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            map[cur[0]][cur[1]] = i++;
            visited[cur[0]][cur[1]] = true;
            int nextX = cur[0] + dx[direction];
            int nextY = cur[1] + dy[direction];

            if (isOutOfRange(nextX, nextY, n) || visited[nextX][nextY]) {
                direction = (direction + 1) % 4;
                nextX = cur[0] + dx[direction];
                nextY = cur[1] + dy[direction];
            }

            if (isOutOfRange(nextX, nextY, n) || visited[nextX][nextY]) {
                break;
            }

            q.offer(new int[] {nextX, nextY});

        }

    }

    private boolean isOutOfRange(int x, int y, int n) {
        return x < 0 || y < 0 || x == n || y == n;
    }
}

/**
 * Simple Solution
 */

class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        int[][] matrix = new int[n][n];
        int left = 0, right = n-1, top = 0, bottom = n-1, num = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        return matrix;
    }
}