import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        Arrays.sort(arr);

        int[] answer = Arrays.stream(arr)
                .filter(n -> n % divisor == 0)
                .toArray();

        if (answer.length == 0) {
            return (new int[] {-1});
        }

        return answer;
    }
}