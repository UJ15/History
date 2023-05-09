import java.io.*;
import java.util.*;

public class Main {
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;

        sliding(a, k);

        System.out.println(max);
    }

    private static void sliding(int[] n, int k) {
        int sum = 0;
        int start = 0;

        for (int i = 0 ; i < k ; i++) {
            sum += n[i];
        }

        max = Math.max(sum, max);

        for (int i = k ; i < n.length ; i++) {
            sum -= n[start++];
            sum += n[i];
            max = Math.max(sum, max);
        }
    }
}

