import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int budget = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = arr[n - 1];
        int limit = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int result = sumArr(n, arr, mid);

            if (result > budget) {
                end = mid - 1;
            } else {
                limit = mid;
                start = mid + 1;
            }

        }

        System.out.println(limit);
    }

    private static int sumArr(int n, int[] arr, int mid) {
        int sum = 0;

        for (int i = 0 ; i < n ; i++) {
            sum += Math.min(arr[i], mid);
        }

        return sum;
    }
}

