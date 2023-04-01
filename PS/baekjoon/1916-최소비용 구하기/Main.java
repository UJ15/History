import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    private static int n;
    private static int e;
    private static List<int[]>[] graph;
    private static int[] dist;
    private static boolean[] visited;
    private static int src;
    private static int dst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());


        graph = new List[n + 1];
        dist = new int[n + 1];
        visited = new boolean[n  + 1];

        createGraph(br);
        dijkstra(src);

        System.out.println(dist[dst]);
    }

    private static void dijkstra(int src) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.offer(new int[] {src, 0});
        Arrays.fill(dist, INF);
        dist[src] = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            if (visited[current[0]]) {
                continue;
            }

            visited[current[0]] = true;

            for (int[] next : graph[current[0]]) {
                if (dist[next[0]] > dist[current[0]] + next[1]) {
                    dist[next[0]] = dist[current[0]] + next[1];

                    q.offer(new int[] {next[0], dist[next[0]]});
                }
            }
        }
    }

    private static void createGraph(BufferedReader br) throws IOException {
        StringTokenizer st;

        for (int i = 1 ; i < graph.length ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < e ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[u].add(new int[] {v, c});
        }

        st = new StringTokenizer(br.readLine());
        src = Integer.parseInt(st.nextToken());
        dst = Integer.parseInt(st.nextToken());
    }
}