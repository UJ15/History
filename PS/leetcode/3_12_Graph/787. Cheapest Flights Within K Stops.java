/**
 * 시간초과
 */

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

/**
 *
 * 다익스트라 활용
 */
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Build graph
        // node -> [[neighbor,distance]]
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) graph.put(i, new ArrayList<>());

        for(int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            graph.get(u).add(new int[] {v, w});
        }

        // int[] -> [node, distance, moves] for every index
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] distance = new int[n];
        Arrays.fill(distance, -1);

        int[] maxMovesUpToNode = new int[n];
        Arrays.fill(maxMovesUpToNode, Integer.MAX_VALUE);

        // Initial mark
        distance[src] = 0;
        pq.offer(new int[] {src, 0, 0});

        // Run Relaxation Algorithm
        while(!pq.isEmpty()) {
            int[] element = pq.poll();
            int node = element[0];
            int dis = element[1];
            int moves = element[2];

            if(maxMovesUpToNode[node] < moves) continue;
            maxMovesUpToNode[node] = moves;

            for(int[] edge : graph.get(node)) {
                int neighbor = edge[0], weight = edge[1];

                int neighborNewDistance = weight + dis;
                if(distance[neighbor] == -1 || neighborNewDistance < distance[neighbor]) {
                    distance[neighbor] = neighborNewDistance;
                }
                // If we have moves left.
                if(k != moves) {
                    pq.offer(new int[] {neighbor, neighborNewDistance, moves + 1});
                }
            }
        }


        return distance[dst];
    }
}