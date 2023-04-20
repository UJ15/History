class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[128];
        int result = 0;
        int maxLen = -1;

        for (int i = 0 ; i < s.length() ; i++) {
            maxLen = Math.max(maxLen, ++count[s.charAt(i)]);
            if (result - maxLen < k) {
                result++;
            } else {
                count[s.charAt(i - result)]--;
            }
        }

        return result;
    }
}