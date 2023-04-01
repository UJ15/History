import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    private static int n;
    private static int m;
    private static int x;
    private static List<int[]>[] graph;
    private static int max;
    private static int[] dist;
    private static int[] goBack;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        graph = new List[n + 1];
        max = -1;
        goBack = new int[n + 1];
        int student = -1;

        createGraph(br);

        dijkstra(x);

        for (int i = 1 ; i <= n ; i++) {
            goBack[i] = dist[i];
        }

        for (int i = 1 ; i <= n ; i++) {
            dijkstra(i);

            max = Math.max(max, dist[x] + goBack[i]);
        }

        System.out.println(max);
    }

    private static void dijkstra(int src) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        visited = new boolean[n + 1];

        dist[src] = 0;
        q.offer(new int[] {src, 0});

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

        for (int i = 1 ; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[u].add(new int[] {v, c});
        }
    }
}