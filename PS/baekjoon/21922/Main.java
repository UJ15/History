import java.io.*;
import java.util.*;


public class Main {

    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[][][] visited;
    private static int result;
    private static int dx[] = {-1, 0, 1, 0};
    private static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        createMap(br);

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (map[i][j] == 9) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(result);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        if (isNoCounted(i, j)) {
            result++;
        }

        for (int k = 0 ; k < 4 ; k++) {
            q.offer(new int[] {i, j, k});
            visited[i][j][k] = true;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            int value = map[x][y];
            int nextX = -1;
            int nextY = -1;

            //System.out.println(x + " " + y + " " + d + " " + value);

            if (value == 0 || value == 9 || value == 1 || value == 2) {
                nextX = x + dx[d];
                nextY = y + dy[d];
            } else if (value == 3) {
                if (d % 2 == 0) {
                    d++;
                } else {
                    d--;
                }
                nextX = x + dx[d];
                nextY = y + dy[d];
            } else if (value == 4) {
                if (d % 2 == 1) {
                    d = (d + 1) % 4;
                } else {
                    d = (d + 3) % 4;
                }
                nextX = x + dx[d];
                nextY = y + dy[d];
            }



            if (isInRange(nextX, nextY) && !visited[nextX][nextY][d]) {
                if ((value == 1 && d % 2 == 1) || (value == 2 && d % 2 == 0)) {
                    continue;
                }
                if (isNoCounted(nextX, nextY)) {
                    result++;
                }
                visited[nextX][nextY][d] = true;
                q.offer(new int[] {nextX, nextY, d});
            }
        }
    }

    private static boolean isNoCounted(int x, int y) {
        for (int i = 0 ; i < 4 ; i++) {
            if (visited[x][y][i]) {
                return false;
            }
        }

        return true;
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    private static void createMap(BufferedReader br) throws IOException {
        map = new int[n][m];
        visited = new boolean[n][m][4];
        result = 0;

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

