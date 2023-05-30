import java.io.*;
import java.util.*;


public class Main {

    private static final int P = 11;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            max = Integer.MIN_VALUE;
            boolean[] visited = new boolean[P];
            int[][] players = new int[P][P];

            for (int i = 0 ; i < P ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0 ; j < P ; j++) {
                    players[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, players, visited, 0);

            System.out.println(max);
        }
    }

    private static void dfs(int index, int[][] players, boolean[] visited, int sum) {
        if (index == P) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0 ; i < P ; i++) {
            if (players[index][i] == 0) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                dfs(index + 1, players, visited, sum + players[index][i]);
                visited[i] = false;
            }
        }
    }
}

