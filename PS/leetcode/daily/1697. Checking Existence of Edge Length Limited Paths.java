/**
 * My Solution
 * TLE
 */

class Solution {
    List<Edge>[] graph;
    boolean[] visited;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        createGraph(n, edgeList);

        return executeQueries(n, queries);
    }

    private boolean[] executeQueries(int n, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        int idx = 0;

        for (int[] query : queries) {
            visited = new boolean[n];
            int s = query[0];
            int d = query[1];
            int limit = query[2];

            result[idx] = dfs(s, d, limit);
            idx++;
        }

        return result;
    }

    private boolean dfs(int s, int d, int limit) {
        if (s == d) {
            return true;
        }

        visited[s] = true;

        for (Edge edge : graph[s]) {
            if (!visited[edge.node] && edge.cost < limit) {
                if (dfs(edge.node, d, limit)) {
                    return true;
                }
            }
        }

        return false;
    }

    private void createGraph(int n, int[][] edgeList) {
        graph = new List[n];

        for (int i = 0 ; i < n ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edgeList) {
            graph[edge[0]].add(new Edge(edge[1], edge[2]));
            graph[edge[1]].add(new Edge(edge[0], edge[2]));
        }
    }
}

class Edge {
    int node;
    int cost;

    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}