import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int current = 1;
        int answer = 0;

        for (int num : order) {
            if (current > num) {
                if (!stack.isEmpty() && stack.pop() == num) {
                    answer++;
                } else {
                    return answer;
                }
            }

            if (current <= num) {
                while (current != num) {
                    stack.push(current++);
                }
                current++;
                answer++;
            }
        }

        return answer;
    }
}