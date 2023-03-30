class Solution {
    int[] parent;
    int[] minDist;

    private int find(int x) {
        while (x != parent[x]) {
            int pa = parent[x];
            int ga = parent[pa];

            parent[x] = ga;
            x = pa;

        }
        return x;
    }

    public int minScore(int n, int[][] roads) {

        parent = new int[n + 1];
        minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            // union u and v

            int pu = find(u);
            int pv = find(v);

            if (pu == pv) {
                minDist[pu] = Math.min(minDist[pu], w);
            } else {
                // union pu
                parent[pv] = pu;
                minDist[pu] = Math.min(minDist[pu], minDist[pv]);
                minDist[pu] = Math.min(minDist[pu], w);
            }

        }

        int pn = find(n);
        return minDist[pn];

        // return -1;
    }
}