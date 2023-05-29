import static java.util.Arrays.stream;

import java.io.*;
import java.util.*;


public class Main {

    private static List<int[]>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 1;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> q2 = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            q.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        while (!q.isEmpty()) {
            if (q2.isEmpty()) {
                q2.offer(q.poll());
                continue;
            }

            int[] cur = q.peek();
            int[] use = q2.peek();

            if (cur[0] >= use[1]) {
                q2.poll();
            }

            q2.offer(q.poll());
            result = Math.max(result, q2.size());
        }

        System.out.println(result);
    }
}

