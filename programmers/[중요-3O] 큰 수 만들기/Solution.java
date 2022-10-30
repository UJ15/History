https://school.programmers.co.kr/learn/courses/30/lessons/42883

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < number.length() ; i++) {
            while(!stack.isEmpty() && stack.peek() < number.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(number.charAt(i));
        }

        if (k > 0) {
            for (int i = 0 ; i < k ; i++) {
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}