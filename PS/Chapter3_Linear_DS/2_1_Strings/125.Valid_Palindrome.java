import java.util.*;

class Solution {

    public boolean isPalindrome(String s) {
        List<Character> list = new ArrayList<>();
        s = s.toUpperCase();

        for (int i = 0 ; i < s.length() ; i++) {
            if (Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                list.add(s.charAt(i));
            }
        }

        int j = list.size() - 1;

        for (int i = 0 ; i < list.size() / 2 ; i++) {
            if (list.get(i) != list.get(j)) {
                return false;
            }

            j--;
        }

        return true;
    }
}