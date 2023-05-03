import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> q2 = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            q.offer(new int[] {s, e});
        }

        int meetingRoom = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            if (!q2.isEmpty()) {
                int[] temp = q2.peek();

                if (temp[1] <= current[0]) {
                    q2.poll();
                }
            }

            q2.offer(current);

            meetingRoom = Math.max(q2.size(), meetingRoom);
        }

        System.out.println(meetingRoom);
    }
}