import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();
        String result = "";

        for (int i = 0 ; i < n ; i++) {
            deque.addLast(new int[] {i + 1, Integer.parseInt(st.nextToken())});
        }

        while (deque.size() > 1) {
            int[] cur = deque.pollFirst();
            result = result + cur[0] + " ";

            if (cur[1] > 0) {
                for (int i = 0 ; i < cur[1] - 1 ; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0 ; i > cur[1] ; i--) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        if (deque.isEmpty()) {
            System.out.println(result);
            return;
        }

        int[] last = deque.pollFirst();

        System.out.println(result + last[0]);
    }
}

