import java.io.*;
import java.util.*;

public class Main {
    private static char[][] map;
    private static Queue<int[]> q;
    private static int r;
    private static int c;
    private static int[] start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();

        createMap(br);

        bfs();

        System.out.println("IMPOSSIBLE");
    }

    private static void bfs() {
        boolean[][] visited = new boolean[r][c];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        q.offer(start);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]][cur[1]] = true;

            if (cur[2] == 0 && isEscape(cur[0], cur[1])) {
                System.out.println(cur[3] + 1);
                System.exit(0);
            }

            for (int i = 0 ; i < 4 ; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX == r || nextY == c) {
                    continue;
                }

                if (!visited[nextX][nextY] && map[nextX][nextY] == '.') {
                    int type = cur[2];

                    if (type == 1) {
                        map[nextX][nextY] = 'F';
                    } else {
                        map[nextX][nextY] = 'J';
                    }

                    q.offer(new int[] {nextX, nextY, type, cur[3] + 1});
                }
            }
        }
    }

    private static boolean isEscape(int x, int y) {
        return x == 0 || y == 0 || x == r - 1 || y == c - 1;
    }

    private static void createMap(BufferedReader br) throws IOException {
        map = new char[r][c];

        for (int i = 0 ; i < r ; i++) {
            String row = br.readLine();
            for (int j = 0 ; j < c ; j++) {
                if (row.charAt(j) == 'J') {
                    start = new int[] {i, j, 0, 0};
                    map[i][j] = 'J';
                } else if (row.charAt(j) == 'F') {
                    q.offer(new int[] {i, j, 1, 0});
                    map[i][j] = 'F';
                }
                map[i][j] = row.charAt(j);
            }
        }
    }
}