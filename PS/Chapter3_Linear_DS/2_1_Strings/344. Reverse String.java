//https://leetcode.com/problems/reverse-string/description/

import java.util.*;

class Solution {
    public void reverseString(char[] s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s) {
            stack.push(ch);
        }

        for (int i = 0 ; i < s.length ; i++) {
            s[i] = stack.pop();
        }
    }
}

//book's solution
/*import java.util.*;

class Solution {
    public void reverseString(char[] s) {
        int j = s.length - 1;

        for (int i = 0 ; i < s.length / 2 ; i++) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            j--;
        }
    }
}*/