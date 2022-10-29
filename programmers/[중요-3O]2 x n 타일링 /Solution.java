https://school.programmers.co.kr/learn/courses/30/lessons/12900

class Solution {
    public int solution(int n) {
        long[] d = new long[n + 1];

        d[1] = 1;
        d[2] = 2;
        d[3] = 3;

        for (int i = 4 ; i <= n ; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 1000000007;
        }

        return (int) d[n];
    }
}