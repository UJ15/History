import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int e;
    private static int count;
    private static List<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        createGraph(br);

        dfs(1);

        System.out.println(count);
    }

    private static void dfs(int start) {
        for (int i : graph[start]) {
            if (!visited[i]) {
                visited[i] = true;
                count++;
                dfs(i);
            }
        }
    }

    private static void createGraph(BufferedReader br) throws IOException {
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        graph = new List[n + 1];
        visited = new boolean[n + 1];
        visited[1] = true;

        for (int i = 1 ; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < e ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
    }
}

