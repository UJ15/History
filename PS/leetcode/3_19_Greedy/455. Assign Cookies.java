class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int content = 0;
        int j = 0;

        for (int i = 0 ; i < s.length ; i++) {
            if (j == g.length) {
                return content;
            }

            if (g[j] <= s[i]) {
                content++;
                j++;
            }
        }

        return content;
    }
}