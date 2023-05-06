import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            tree = new int[n + 1];

            for (int i = 0 ; i < n - 1 ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                tree[child] = parent;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Set<Integer> routeA = new HashSet<>();

            while (a != 0) {
                routeA.add(a);
                a = tree[a];
            }

            while (b != 0) {
                if (routeA.contains(b)) {
                    System.out.println(b);
                    break;
                }
                b = tree[b];
            }
        }
    }
}