import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0 ; i < s.length() ; i++){
            if (stack.empty())
                stack.push(s.charAt(i));
            else{
                if (stack.peek() == '('){
                    if (s.charAt(i) == ')')
                        stack.pop();
                    else
                        stack.push(s.charAt(i));
                }
                else if (stack.peek() == '{'){
                    if (s.charAt(i) == '}')
                        stack.pop();
                    else
                        stack.push(s.charAt(i));
                }
                else if (stack.peek() == '['){
                    if (s.charAt(i) == ']')
                        stack.pop();
                    else
                        stack.push(s.charAt(i));
                }
            }
        }
        
        if (stack.empty()){
            return true;
        }
        else{
            return false;
        }
    }
}
