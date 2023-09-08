import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int result;
    private static int[] currentCoordinate;
    private static int direction;
    private static boolean isEnd;

    public static void main(String[] args) throws IOException {
        result = 0;
        initMap();

        while (!isEnd) {
            cleanCurrentPoint();

            if (isCleanAround()) {
                goToReverse();
            }
            else {
                rotate();
                goToForward();
            }
        }

        System.out.println(result);
    }

    private static void cleanCurrentPoint() {
        if (map[currentCoordinate[0]][currentCoordinate[1]] == 0) {
            result++;
            map[currentCoordinate[0]][currentCoordinate[1]] = -1;
        }
    }

    private static boolean isCleanAround() {
        for (int i = 0 ; i < 4 ; i++) {
            int nextX = currentCoordinate[0] + dx[i];
            int nextY = currentCoordinate[1] + dy[i];

            if (isOutOfRange(nextX, nextY)) {
                continue;
            }

            if (map[nextX][nextY] == 0) {
                return false;
            }
        }

        return true;
    }

    private static void goToReverse() {
        int nextX = currentCoordinate[0] - dx[direction];
        int nextY = currentCoordinate[1] - dy[direction];

        if (map[nextX][nextY] == 1) {
            isEnd = true;
            return;
        }

        currentCoordinate[0] = nextX;
        currentCoordinate[1] = nextY;

    }

    private static void rotate() {
        direction--;

        if (direction < 0) {
            direction = 3;
        }
    }

    private static void goToForward() {
        int nextX = currentCoordinate[0] + dx[direction];
        int nextY = currentCoordinate[1] + dy[direction];

        if (map[nextX][nextY] == 0) {
            currentCoordinate[0] = nextX;
            currentCoordinate[1] = nextY;
        }
    }

    private static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= map.length || y >= map[0].length;
    }

    private static void initMap() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        map = new int[n][m];
        currentCoordinate = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        direction = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

