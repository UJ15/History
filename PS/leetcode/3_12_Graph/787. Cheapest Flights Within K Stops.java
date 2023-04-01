class Solution {
    List<Node>[] graph;
    int min;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        graph = new List[n];
        min = Integer.MAX_VALUE;

        createGraph(flights);
        dijkstra(src, dst, k);

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void dijkstra(int src, int dst, int k) {
        Queue<Node> q = new LinkedList<>();
        int stop = 0;

        q.offer(new Node(src, 0));

        while (!q.isEmpty() && stop <= k + 1) {
            int size = q.size();

            for (int i = 0 ; i < size ; i++) {
                Node current = q.poll();

                if (current.v == dst) {
                    min = Math.min(min, current.cost);
                } else {
                    for (Node next : graph[current.v]) {
                        if (min > next.cost + current.cost) {
                            q.offer(new Node(next.v, next.cost + current.cost));
                        }
                    }
                }
            }

            stop++;
        }
    }

    private void createGraph(int[][] flights) {
        for (int i = 0 ; i < graph.length ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            graph[flight[0]].add(new Node(flight[1], flight[2]));
        }
    }
}

class Node implements Comparable<Node> {
    int v;
    int cost;

    public Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

/**
 * 공부해야할 풀이
 */

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int prev[]=new int[n];

        Arrays.fill(prev,Integer.MAX_VALUE);

        prev[src]=0;

        for(int i=0;i<=k;i++){
            int cur[]=new int[n];

            for(int j=0;j<n;j++) {
                cur[j]=prev[j];
            }

            for(int e[]:flights){
                int u=e[0],v=e[1],wt=e[2];

                if(prev[u]!=Integer.MAX_VALUE&&prev[u]+wt<cur[v]){
                    cur[v]=prev[u]+wt;
                }
            }

            for(int j=0;j<n;j++) {
                prev[j]=cur[j];
            }
        }

        return prev[dst]==Integer.MAX_VALUE?-1:prev[dst];
    }
}