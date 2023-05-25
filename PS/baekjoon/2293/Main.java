import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        long[] d = new long[k + 1];

        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        d[0] = 1;
        for (int i = 0 ; i < n ; i++) {
            int coin = arr[i];
            for (int j = 1 ; j <= k ; j++) {
                if (j >= coin) {
                    d[j] = d[j] + d[j - coin];
                }
            }
        }


        System.out.println(d[k]);
    }
}

