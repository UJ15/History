class Solution {
    Map<Character, Integer> map;

    public int longestPalindrome(String s) {
        map = new HashMap<>();
        int n = s.length();
        int odd = 0;

        for (int i = 0 ; i < s.length() ; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (char key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                odd++;
            }
        }

        return odd != 0 ? n - odd + 1 : n;
    }
}