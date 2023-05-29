import static java.util.Arrays.stream;

import java.io.*;
import java.util.*;


public class Main {

    private static List<int[]>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new List[n];

        for (int i = 0 ; i < n ; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[u].add(new int[] {v, w});
            tree[v].add(new int[] {u, w});
        }

        int diameter = getDiameter(n);
    }

    private static int getDiameter(int n) {
        int[] dist = bfs(0, n);
        int start = 0;
        for (int i = 1 ; i < n ; i++) {
            if (dist[i] > dist[start]) {
                start = i;
            }
        }
        dist = bfs(start, n);
        start = 0;
        int diameter = Integer.MIN_VALUE;
        for (int i = 1 ; i < n ; i++) {
            if (dist[i] > dist[start]) {
                start = i;
                diameter = Math.max(diameter, dist[i]);
            }
        }

        return diameter;
    }

    private static int[] bfs(int start, int n) {
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int[] next : tree[cur]) {
                if (!visited[next[0]]) {
                    visited[next[0]] = true;
                    dist[next[0]] = dist[cur] + next[1];
                    q.offer(next[0]);
                }
            }
        }

        return dist;
    }
}

