import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0 ; i < numbers.length ; i++) {
            while (!stack.isEmpty()) {
                int[] cur = stack.peek();
                if (cur[1] < numbers[i]) {
                    answer[cur[0]] = numbers[i];
                    stack.pop();
                } else {
                    break;
                }
            }

            stack.push(new int[] {i, numbers[i]});
        }

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            answer[cur[0]] = -1;
        }

        return answer;
    }
}