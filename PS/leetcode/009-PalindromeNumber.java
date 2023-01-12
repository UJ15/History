import java.util.*;

class Solution {
    public boolean isPalindrome(int x) {
        String number = String.valueOf(x);

        int j = number.length() - 1;

        for (int i = 0 ; i < number.length() ; i++) {
            if (number.charAt(i) != number.charAt(j)) {
                return false;
            }
            j--;
        }

        return true;
    }
}