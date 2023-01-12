https://school.programmers.co.kr/learn/courses/30/lessons/12913

class Solution {
    int solution(int[][] land) {
        int len = land.length;
        int[][] d = new int[len][4];
        d[0] = land[0];

        for (int i = 1 ; i < len ; i++) {
            for (int j = 0 ; j < 4 ; j++) {
                int first = d[i - 1][(j + 1) % 4];
                int second = d[i - 1][(j + 2) % 4];
                int third = d[i - 1][(j + 3) % 4];
                d[i][j] = land[i][j] + Math.max(first , Math.max(second, third));
            }
        }

        int answer = 0;

        for (int i = 0 ; i < 4 ; i++) {
            answer  = Math.max(d[len - 1][i], answer);
        }

        return answer ;
    }
}