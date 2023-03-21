class Solution {
    final int MAX_FARE = 1_000_000;
    int[][] floyd;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        floyd = new int[n + 1][n + 1];
        createFloyd(n, fares);

        int min = floyd[s][a] + floyd[s][b];

        for (int i = 1 ; i <= n ; i++) {
            min = Math.min(min, floyd[s][i] + floyd[i][a] + floyd[i][b]);
        }

        return min;
    }

    private void createFloyd(int n, int[][] fares) {
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                if (i == j) {
                    floyd[i][j] = 0;
                } else {
                    floyd[i][j] = MAX_FARE;
                }
            }
        }

        for (int[] fare : fares) {
            floyd[fare[0]][fare[1]] = fare[2];
            floyd[fare[1]][fare[0]] = fare[2];
        }

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                for (int k = 1 ; k <= n ; k++) {
                    floyd[j][k] = Math.min(floyd[j][k], floyd[j][i] + floyd[i][k]);
                }
            }
        }
    }
}