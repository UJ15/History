import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[][][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        createGraph(br);

        bfs(new int[] {0, 0, 0});

        System.out.println(map[n - 1][n - 1][1]);
    }

    private static void bfs(int[] node) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(node);
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0 ; i < 4 ; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX == n || nextY == n) {
                    continue;
                }

                if (map[nextX][nextY][0] == 1) {
                    if (map[nextX][nextY][1] > cur[2]) {
                        map[nextX][nextY][1] = cur[2];
                        q.offer(new int[] {nextX, nextY, cur[2]});
                    }
                } else {
                    if (map[nextX][nextY][1] > cur[2] + 1) {
                        map[nextX][nextY][1] = cur[2] + 1;
                        q.offer(new int[] {nextX, nextY, cur[2] + 1});
                    }
                }
            }
        }
    }

    private static void createGraph(BufferedReader br) throws IOException {

        n = Integer.parseInt(br.readLine());
        map = new int[n][n][2];

        for (int i = 0 ; i < n ; i++) {
            String s = br.readLine();
            for (int j = 0 ; j < n ; j++) {
                map[i][j][0] = s.charAt(j) - '0';
                map[i][j][1] = Integer.MAX_VALUE;
            }
        }
    }
}

