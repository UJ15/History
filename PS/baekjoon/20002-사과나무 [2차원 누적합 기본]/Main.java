import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;
    private static int[][] sumMap;
    private static int n;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        createMap(br);
        max = Integer.MIN_VALUE;

        //i * i 만큼의 부분구간합을 구하는 과정이다. 누적합 배열에서 Description의 그림과 같이 부분구간합을 구해서 최댓값 비교를 한다.
        for (int i = 1 ; i <= n ; i++) {
            for (int r = i ; r <= n ; r++) {
                for (int c = i ; c <= n ; c++) {
                    max = Math.max(max, sumMap[r][c] + sumMap[r - i][c - i] - sumMap[r - i][c] - sumMap[r][c - i]);
                }
            }
        }

        System.out.println(max);
    }

    private static void createMap(BufferedReader br) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        sumMap = new int[n + 1][n + 1];

        for (int i = 1 ; i <= n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
/**
 * 누적합 2차원 배열을 만들어줘야 한다.
 */

        //각 행의 누적합
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                sumMap[i][j] = sumMap[i][j - 1] + map[i][j];
            }
        }

        //행의 누적합합이 구해진 상태에서 누적합 배열의 각 열의 누적합을 구한다.
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                sumMap[i][j] = sumMap[i - 1][j] + sumMap[i][j];
            }
        }
    }
}