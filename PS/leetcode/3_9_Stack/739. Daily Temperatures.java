/**
 *스택 두개에 값과 인덱스를 넣고 현재 온도와 스택 내의 온도를 비교하며
 * 현재 온도가 더 클 경우 현재 인덱스와 스택 인덱스의 차이를 결과 배열 스택 인덱스에 넣어주면 된다.
 */


import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0 ; i < temperatures.length ; i++) {
            if (stack.isEmpty()) {
                stack.push(temperatures[i]);
                stack2.push(i);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() < temperatures[i]) {
                stack.pop();
                int idx = stack2.pop();
                result[idx] = i - idx;
            }

            stack.push(temperatures[i]);
            stack2.push(i);
        }

        return result;
    }
}