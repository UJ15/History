https://school.programmers.co.kr/learn/courses/30/lessons/42898

class Solution {
    int[][] map;
    public int solution(int m, int n, int[][] puddles) {

        initMap(m, n, puddles);

        for (int i = 1 ; i < m ; i++) {
            for (int j = 1 ; j < n ; j++) {
                if (map[i][j] > -1) {
                    if (map[i - 1][j] == -1 && map[i][j - 1] > -1) {
                        map[i][j] = map[i][j - 1];
                    } else if (map[i - 1][j] > -1 && map[i][j - 1] == -1) {
                        map[i][j] = map[i - 1][j];
                    } else if (map[i - 1][j] > -1 && map[i][j - 1] > -1) {
                        map[i][j] = (map[i - 1][j] + map[i][j - 1]) % 1000000007;
                    }
                }
            }
        }

        return map[m - 1][n - 1];
    }

    private void initMap(int m, int n, int[][] puddles) {
        map = new int[m][n];

        for (int[] puddle : puddles) {
            map[puddle[0] - 1][puddle[1] - 1] = -1;
        }

        for (int i = 0 ; i < n ; i++) {
            if (map[0][i] != -1) {
                map[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 0 ; i < m ; i++) {
            if (map[i][0] != -1) {
                map[i][0] = 1;
            } else {
                break;
            }
        }
    }
}