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
            
                //스택이 비어있지 않고 스택의 문자가 현재 문자보다 큰경우(사전식 정렬) , 스택에 있는 문자가 뒤에 또 있을때
                while (!stack.empty() && stack.peek() > s.charAt(i) && freq[stack.peek() - 'a'] > 0){
                flag[stack.pop() - 'a'] = false;//스택에서 지우고 방문 하지 않은걸로 처리
                }
            
                stack.push(s.charAt(i));
                flag[s.charAt(i) - 'a'] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()){
            sb.insert(0, stack.pop()); //0번째 인덱스에 pop을 삽입
        }
        
        return sb.toString();
        
    }
}
