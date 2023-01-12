import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = p;

        while(!isProper(answer)) {
            answer = convert(answer);
        }

        return answer;
    }

    private String convert(String p) {
        if (p.equals("")) {
            return p;
        }

        String[] split = splitStr(p);
        String newStr = "";

        if (isProper(split[0])) {
            return split[0] + convert(split[1]);
        } else {
            newStr = "(" + convert(split[1]) + ")" + flip(split[0]);
        }

        return newStr;
    }

    private String flip(String p) {
        if (p.equals("")) {
            return "";
        }

        String newString = p.substring(1, p.length() - 1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < newString.length() ; i++) {
            if (newString.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }

        return sb.toString();
    }

    private String[] splitStr(String str) {
        int idx = 0;
        int left = 0;
        int right = 0;

        while(left == 0 || left != right) {
            if (str.charAt(idx) == '(') {
                left++;
            } else {
                right++;
            }

            idx++;
        }

        return new String[] {str.substring(0, idx), str.substring(idx)};
    }

    private boolean isProper(String p) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < p.length() ; i++) {
            if (p.charAt(i) == '(') {
                stack.push(p.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}