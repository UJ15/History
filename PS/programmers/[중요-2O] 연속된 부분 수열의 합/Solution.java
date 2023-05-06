import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] result = {-1, -1};

        int sum = 0;
        int start = 0;

        for (int i = 0 ; i < sequence.length ; i++) {
            sum += sequence[i];

            while (sum > k) {
                sum -= sequence[start];
                start++;
            }

            if (sum == k && (result[0] < 0 || i - start < result[1] - result[0])) {
                result = new int[] {start, i};
            }
        }

        return result;
    }
}