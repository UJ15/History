import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);

        int sum = 45;
        for (int num : numbers) {
            sum -= num;
        }
        return sum;
    }
}