import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n + 1];
        d[1] = 0;

        for (int i = 2 ; i <= n ; i++) {
            int value = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                value = Math.min(value, d[i / 3] + 1);
            }

            if (i % 2 == 0) {
                value = Math.min(value, d[i / 2] + 1);
            }

            value = Math.min(value, d[i - 1] + 1);

            d[i] = value;
        }

        System.out.println(d[n]);
    }
}