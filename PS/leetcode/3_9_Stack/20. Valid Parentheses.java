import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty() && ((stack.peek() == '(' && s.charAt(i) == ')')
                    || (stack.peek() == '{' && s.charAt(i) == '}')
                    || (stack.peek() == '[' && s.charAt(i) == ']'))){

                stack.pop();
            } else {
                return false;
            }

        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}