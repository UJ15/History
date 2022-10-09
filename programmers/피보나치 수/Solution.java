https://school.programmers.co.kr/learn/courses/30/lessons/12945

class Solution {
    public int solution(int n) {
        int[] d = new int[n + 1];
        d[0] = 0;
        d[1] = 1;

        for (int i = 2 ; i <= n ; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 1234567;
        }

        return d[n];
    }
}