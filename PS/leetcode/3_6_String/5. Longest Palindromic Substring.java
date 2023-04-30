class Solution {
    private int max;
    private int start;

    public String longestPalindrome(String s) {
        max = 0;
        start = 0;
        if (s.length() < 2) {
            return s;
        }

        for (int i = 0 ; i < s.length() ; i++) {
            expand(i, i + 1, s);
            expand(i, i + 2, s);
        }

        return s.substring(start, start + max);
    }

    private void expand(int i, int j, String s) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        if (j - i - 1 > max) {
            max = j - i - 1;
            start = i + 1;
        }
    }
}