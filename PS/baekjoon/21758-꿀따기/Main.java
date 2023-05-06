import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] sum = new long[n];
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i++) {
            long honey = Long.parseLong(st.nextToken());

            if (i == 0) {
                sum[i] = honey;
                arr[i] = honey;
                continue;
            }

            arr[i] = honey;
            sum[i] = sum[i - 1] + honey;
        }
        long result = 0;

        for (int i = 1 ; i < n - 1 ; i++) {
            result = Math.max(result, sum[n - 1] - arr[0] - arr[i] + sum[n - 1] - sum[i]);
        }
        for (int i = 1 ; i < n - 1 ; i++) {
            result = Math.max(result, sum[n - 1] - arr[n - 1] - arr[i] + sum[i] - arr[i]);
        }
        for (int i = 1 ; i < n - 1 ; i++) {
            result = Math.max(result, sum[i] - arr[0] + sum[n - 1] - arr[n - 1] - sum[i] + arr[i]);
        }

        System.out.println(result);
    }
}