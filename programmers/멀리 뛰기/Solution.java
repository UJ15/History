https://school.programmers.co.kr/learn/courses/30/lessons/12914

class Solution {
    public long solution(int n) {
        long[] d = new long[n + 2];
        d[0] = 0;
        d[1] = 1;
        d[2] = 2;

        for (int i = 3 ; i <= n ; i++) {
            //마지막 칸에 한칸 뛴 경우 + 두 칸 뛴경우를 더해주면 된다.
            d[i] = (d[i - 1] + d[i - 2]) % 1234567;
        }

        return d[n];
    }
}