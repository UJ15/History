import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int result = 0;

        if (n == 1 || n == 0) {
            result = 1;
        }

        if (n > 1) {
            int[] d = new int[n + 1];

            d[0] = 1;
            d[1] = 1;

            for (int i = 2 ; i <= n ; i++) {
                d[i] = (d[i - 1] + d[i - 2] * 2) % 10007;
            }

            result = d[n];
        }


        System.out.println(result);
    }
}