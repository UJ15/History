class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int w1 = word1.length();
        int w2 = word2.length();
        int minLength = Math.min(w1, w2);
        int idx = 0;

        while (idx < minLength) {
            sb.append(word1.charAt(idx));
            sb.append(word2.charAt(idx++));
        }

        if (w1 > w2) {
            while (idx < w1) {
                sb.append(word1.charAt(idx++));
            }
        } else {
            while (idx < w2) {
                sb.append(word2.charAt(idx++));
            }
        }

        return sb.toString();
    }
}