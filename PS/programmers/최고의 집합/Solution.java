import java.util.*;

class Solution {

    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int length = n;

        if (s / n == 0) {
            return new int[] {-1};
        }

        for (int i = 0 ; i < length ; i++) {
            int max = s / n;
            answer[i] = max;
            s = s - max;
            n--;
        }

        return answer;
    }
}