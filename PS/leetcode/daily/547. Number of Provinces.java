class Solution {
    private boolean[] visited;
    private List<Integer>[] graph;

    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        graph = new List[isConnected.length];
        visited = new boolean[isConnected.length];

        for (int i = 0 ; i < isConnected.length ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < isConnected.length ; i++) {
            for (int j = 0 ; j < isConnected[0].length ; j++) {
                if (i == j) {
                    continue;
                }

                if (isConnected[i][j] == 1) {
                    graph[i].add(j);
                }
            }
        }

        for (int i = 0 ; i < isConnected.length ; i++) {
            for (int j = 0 ; j < isConnected[0].length ; j++) {
                if (!visited[i] && isConnected[i][j] == 1) {
                    dfs(i);
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(int i) {
        visited[i] = true;

        for (int n : graph[i]) {
            if (!visited[n]) {
                dfs(n);
            }
        }
    }
}

//Another

class Solution {
    private boolean[][] visited;

    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        visited = new boolean[isConnected.length][isConnected.length];

        for (int i = 0 ; i < isConnected.length ; i++) {
            for (int j = 0 ; j < isConnected[0].length ; j++) {
                if (!visited[i][j] && isConnected[i][j] == 1) {
                    dfs(i, j, isConnected);
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(int i, int j, int[][] isConnected) {
        visited[i][j] = true;
        visited[j][i] = true;

        for (int k = 0 ; k < isConnected.length ; k++) {
            if (!visited[j][k] && isConnected[j][k] == 1) {
                dfs(j, k, isConnected);
            }
        }
    }
}

//faster

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(isConnected, visited, i);
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            if (isConnected[node][neighbor] == 1 && !visited[neighbor]) {
                dfs(isConnected, visited, neighbor);
            }
        }
    }
