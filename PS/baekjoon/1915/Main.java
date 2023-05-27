import static java.util.Arrays.stream;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int[][] map = new int[n + 1][m + 1];

        for (int i = 0 ; i < n ; i++) {
            String s = br.readLine();
            for (int j = 0 ; j < m ; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        int max = 0;

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= m ; j++) {
                if (board[i - 1][j - 1] == 1) {
                    int min = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]);
                    map[i][j] = min + 1;

                    max = Math.max(max, map[i][j]);
                }
            }
        }

        System.out.println(max * max);
    }
}

