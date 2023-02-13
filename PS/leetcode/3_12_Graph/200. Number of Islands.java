class Solution {
    private char[][] map;
    private boolean[][] visited;
    private int result;

    public int numIslands(char[][] grid) {
        result = 0;
        map = grid;
        visited = new boolean[map.length][map[0].length];

        for (int i = 0 ; i < map.length ; i++) {
            for (int j = 0 ; j < map[0].length ; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    result++;
                    dfs(i, j);
                }
            }
        }

        return result;
    }

    private void dfs(int i, int j) {
        visited[i][j] = true;

        if (i < map.length - 1 && !visited[i + 1][j] && map[i + 1][j] == '1') {
            dfs(i + 1, j);
        }

        if (i > 0 && !visited[i - 1][j] && map[i - 1][j] == '1') {
            dfs(i - 1, j);
        }

        if (j < map[0].length - 1 && !visited[i][j + 1] && map[i][j + 1] == '1') {
            dfs(i, j + 1);
        }

        if (j > 0 && !visited[i][j - 1] && map[i][j - 1] == '1') {
            dfs(i, j - 1);
        }
    }
}