import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long result = dp(n);

        System.out.println(result);
    }

    private static long dp(int n) {
        if (n < 2) {
            return 1;
        }

        long[] d  = new long[n + 1];

        d[1] = 1;
        d[2] = 1;

        for (int i = 3 ; i <= n ; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        return d[n];
    }
}

