import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = 0;

        int[] friendFee = new int[n + 1];
        parents = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= n ; i++) {
            int fee = Integer.parseInt(st.nextToken());
            q.offer(new int[] {i, fee});
            friendFee[i] = fee;
            parents[i] = i;
        }

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        while (!q.isEmpty() && k >= 0) {
            int[] current = q.poll();

            int root = find(current[0]);
            if (!visited[root]) {
                k -= friendFee[current[0]];
                result += friendFee[current[0]];
                visited[root] = true;
            }
        }

        if (!q.isEmpty()) {
            System.out.println("Oh no");
        } else {
            System.out.println(result);
        }
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parents[rootB] = rootA;
        }
    }

    private static int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }
}
