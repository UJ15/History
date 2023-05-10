import java.io.*;

public class Main {

    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] d = new int[n];

        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0 ; i < n ; i++) {
            d[i] = 1;
            for (int j = 0 ; j < i ; j++) {
                if (arr[j] < arr[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                    max = Math.max(d[i], max);
                }
            }
        }

        System.out.println(n - max);
    }
}

