import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            Deque<int []> deque = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            st = new StringTokenizer(br.readLine());

            for (int i = 0 ; i < n ; i++) {
                int p = Integer.parseInt(st.nextToken());
                deque.addLast(new int[] {p, i});
                pq.offer(p);
            }

            while (!deque.isEmpty() && !pq.isEmpty()) {
                int[] peek = deque.peekFirst();
                if (peek[0] < pq.peek()) {
                    deque.addLast(deque.pollFirst());
                } else {
                    pq.poll();
                    int[] temp = deque.pollFirst();
                    if (temp[1] == target) {
                        System.out.println(n - deque.size());
                    }
                }
            }

            t--;
        }
    }
}