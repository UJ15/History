import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long left = 0;
        long right = (long) times[times.length - 1] * n;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long peoples = 0;

            for (int time : times) {
                peoples += (long) mid / time;
            }

            if (peoples >= n) {
                answer = mid;
                right = mid - 1;
            } else if (peoples < n) {
                left = mid + 1;
            }
        }

        return answer;
    }
}