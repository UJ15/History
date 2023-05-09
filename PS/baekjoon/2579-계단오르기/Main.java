import java.io.*;
import java.util.*;

public class Main {
    private static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] steps = new int[n];
        d = new int[n];

        for (int i = 0 ; i < n ; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        if (n < 3) {
            System.out.println(Arrays.stream(steps).sum());
            return;
        }

        dp(steps);

        System.out.println(d[n - 1]);
    }

    private static void dp(int[] steps) {
        d[0] = steps[0];
        d[1] = steps[0] + steps[1];
        d[2] = Math.max(d[0] + steps[2], steps[1] + steps[2]);

        for (int i = 3; i < steps.length ; i++) {
            d[i] = Math.max(d[i - 3] + steps[i - 1] + steps[i], d[i - 2] + steps[i]);
        }
    }
}

