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

//Second

class Solution {
    private char[][] map;
    private int islands;
    private boolean[][] visited;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        map = grid;
        islands = 0;
        visited = new boolean[map.length][map[0].length];

        for (int i = 0 ; i < map.length ; i++) {
            for (int j = 0 ; j < map[0].length ; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(int i, int j) {
        visited[i][j] = true;

        for (int k = 0 ; k < 4 ; k++) {
            int nextI = i + dx[k];
            int nextJ = j + dy[k];

            if (nextI < 0 || nextJ < 0 || nextI == map.length || nextJ == map[0].length) {
                continue;
            }

            if (map[nextI][nextJ] == '1' && !visited[nextI][nextJ]) {
                dfs(nextI, nextJ);
            }
        }
    }
}