class Solution {
    private boolean[] visited;

    public int numSimilarGroups(String[] strs) {
        visited = new boolean[strs.length];
        int result = 0;

        for (int i = 0 ; i < strs.length ; i++) {
            if (!visited[i]) {
                result++;
                dfs(i, strs);
            }
        }

        return result;
    }

    private void dfs(int idx, String[] strs) {
        visited[idx] = true;
        String cur = strs[idx];

        for (int i = 0 ; i < strs.length ; i++) {
            if (!visited[i] && isSimilar(cur, strs[i])) {
                dfs(i, strs);
            }
        }
    }

    private boolean isSimilar(String cur, String str) {
        int diff = 0;

        for (int i = 0 ; i < cur.length() ; i++) {
            if (cur.charAt(i) != str.charAt(i)) {
                diff++;
            }
        }

        return (diff == 0 || diff == 2);
    }
}