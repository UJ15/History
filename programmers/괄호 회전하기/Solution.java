https://school.programmers.co.kr/learn/courses/30/lessons/76502

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0 ; i < s.length() ; i++) {

            if (validation(s)) {
                answer++;
            }

            char c = s.charAt(0);
            s = s.substring(1) + c;
        }

        return answer;
    }

    private boolean validation(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < s.length() ; i++) {
            char bracket = s.charAt(i);
            if (bracket == '[' || bracket == '{' || bracket == '(') {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if (bracket == ']' && open != '[' ||
                        bracket == '{' && open != '}' ||
                        bracket == '(' && open != ')') {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}