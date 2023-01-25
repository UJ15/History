//https://leetcode.com/problems/longest-palindromic-substring/description/

//substring을 활용한 palindrome찾기

class Solution {
    public String longestPalindrome(String s) {
        String palindrome = "";
        if (s.length() == 1) {
            return s;
        }

        for (int i = 0 ; i < s.length() ; i++) {
            for (int j = i + palindrome.length() ; j < s.length() ; j++) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    if (palindrome.length() < j + 1 - i) {
                        palindrome = s.substring(i, j + 1);
                    }
                }
            }
        }

        return palindrome;
    }

    private boolean isPalindrome(String str) {
        int j = str.length() - 1;
        int i = 0;

        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}