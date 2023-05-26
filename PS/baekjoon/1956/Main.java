import java.io.*;
import java.util.*;


public class Main {

    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][n + 1];

        for (int i = 1 ; i <= n ; i++) {
            Arrays.fill(map[i], 1000000000);
        }

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for (int k = 1 ; k <= n ; k++) {
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 1 ; j <= n ; j++) {
                    if (i != j) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 1 ; i <= n ; i++) {
            for (int j = i + 1 ; j <= n ; j++) {
                if (map[i][j] < 1000000000 && map[j][i] < 1000000000) {
                    result = Math.min(result, map[i][j] + map[j][i]);
                }
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}

