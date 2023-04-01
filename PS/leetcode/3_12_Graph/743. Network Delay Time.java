/**
 * 다익스트라 기본문제
 * Heap을 이용해 풀이
 * 출발지점부터 모든 정점간 최단거리를 구하고 제일 최단거리중 최장거리를 리턴한다.
 * 문제의 조건이 모든 정점에 도달하는 최소시간이기 때문에
 * 만약 정점중 최단거리 정보가 없다면 연결되어 있지 않다는 뜻이기 때문에 -1을 반환한다.
 */

class Solution {
    List<Node>[] graph;
    int[] dist;
    boolean[] visited;

    public int networkDelayTime(int[][] times, int n, int k) {
        //초기화
        graph = new List[n + 1];
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        int max = 0;

        createGraph(times);
        dijkstra(n, k);

        for (int i = 1 ; i < dist.length ; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, dist[i]);
        }

        return max;
    }

    private void dijkstra(int n, int k) {
        //초기화
        PriorityQueue<Node> q = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        //출발점 큐에 추가
        q.offer(new Node(k, 0));

        //다익스트라 알고리즘으로 정점간 최단거리 갱신
        while (!q.isEmpty()) {
            Node current = q.poll();

            if (visited[current.v]) {
                continue;
            }

            visited[current.v] = true;

            for (Node next : graph[current.v]) {
                if (dist[next.v] > dist[current.v] + next.cost) {
                    dist[next.v] = dist[current.v] + next.cost;

                    q.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    //그래프 생성
    private void createGraph(int[][] times) {
        for (int i = 1 ; i < graph.length ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            graph[time[0]].add(new Node(time[1], time[2]));
        }
    }
}

//Heap 자료구조(우선순위큐) 사용을 위해 Comparable 인터페이스 구현
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