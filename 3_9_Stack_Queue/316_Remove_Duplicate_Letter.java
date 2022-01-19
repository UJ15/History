import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        int freq[] = new int[26];
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0 ; i < s.length() ; i++){
            freq[s.charAt(i) - 'a']++;
        }
        
        boolean flag[] = new boolean[26];
        for (int i = 0 ; i < s.length() ; i++){
            freq[s.charAt(i) - 'a']--;
            
            if (!flag[s.charAt(i) - 'a']){
            
                while (!stack.empty() && stack.peek() > s.charAt(i) && freq[stack.peek() - 'a'] > 0){
                flag[stack.pop() - 'a'] = false;
                }
            
                stack.push(s.charAt(i));
                flag[s.charAt(i) - 'a'] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()){
            sb.insert(0, stack.pop());
        }
        
        return sb.toString();
        
    }
}
