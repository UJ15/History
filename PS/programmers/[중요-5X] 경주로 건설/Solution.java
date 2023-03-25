//시간 초과
class Solution {
    private int cost;
    private int[][] map;
    private boolean[][] visited;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board) {
        int n = board.length - 1;
        map = board;
        visited = new boolean[n + 1][n + 1];
        cost = Integer.MAX_VALUE;

        dfs(0, 0, -1, n, 0);
        visited[0][0] = true;

        return cost;
    }

    private void dfs(int i, int j, int direction, int n, int currentCost) {
        if (i == n && j == n || currentCost >= cost) {
            cost = Math.min(cost, currentCost);
            return;
        }

        for (int k = 0 ; k < 4 ; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];

            if (ni < 0 || ni > n || nj < 0 || nj > n) {
                continue;
            }

            if (!visited[ni][nj] && map[ni][nj] == 0) {
                visited[ni][nj] = true;

                if (direction == -1 || direction == k) {
                    dfs(ni, nj, k, n, currentCost + 100);
                } else {
                    dfs(ni, nj, k, n, currentCost + 600);
                }

                visited[ni][nj] = false;
            }
        }
    }
}