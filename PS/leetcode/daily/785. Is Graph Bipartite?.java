class Solution {
    private List<int[]>[] map;
    private boolean[] visited;
    private int[] colors;

    public boolean isBipartite(int[][] graph) {
        Queue<int[]> q = new LinkedList<>();
        createGraph(graph);


        for (int k = 0 ; k < colors.length ; k++) {
            if (visited[k]) {
                continue;
            }

            q.offer(new int[] {k, 1});
            visited[k] = true;
            colors[k] = 1;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int node = cur[0];
                int color = cur[1];
                int nextColor = 0;
                if (color == 1) {
                    nextColor = -1;
                } else {
                    nextColor = 1;
                }



                for (int[] next : map[node]) {
                    if (!visited[next[0]]) {
                        colors[next[0]] = nextColor;
                        visited[next[0]] = true;
                        q.offer(new int[] {next[0], nextColor});
                    } else {
                        if (colors[next[0]] == color) {
                            return false;
                        }
                    }
                }
            }
        }


        return true;
    }

    private void createGraph(int[][] graph) {
        int len = graph.length;
        visited = new boolean[len];
        map = new List[len];
        colors = new int[len];

        for (int i = 0 ; i < len ; i++) {
            map[i] = new ArrayList<>();
            for (int j = 0 ; j < graph[i].length ; j++) {
                map[i].add(new int[] {graph[i][j], 0});
            }
        }
    }
}