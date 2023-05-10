import java.io.*;
import java.util.*;


public class Main {

    private static int[][] map;
    private static int n;
    private static int m;
    private static int lastCheese;
    private static int hour;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        createMap(br);

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(hour + "\n" + lastCheese);
    }

    private static void bfs(int x, int y) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int count = 1;
        visited[x][y] = true;
        map[x][y] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0 ; i < 4 ; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if (isOutOfRange(nextX, nextY)) {
                    continue;
                }

                if (map[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                    q.offer(new int[] {nextX, nextY});
                    //시작지점일때 주변 1 탐색을 하지 않기위해 시작 인덱스를 제외시켜줬다.
                } else if (!(cur[0] == x && cur[1] == y) && map[nextX][nextY] == 1) {
                    count++;
                    map[nextX][nextY] = 0;
                }
                visited[nextX][nextY] = true;
            }
        }

        hour++;
        lastCheese = count;
    }

    private static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x == n || y == m;
    }

    private static void createMap(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lastCheese = 0;

        map = new int[n][m];

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

