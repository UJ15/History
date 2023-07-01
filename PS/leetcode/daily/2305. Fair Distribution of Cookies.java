class Solution {
    private int result = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        dfs(cookies, 0, k, new int[k]);

        return result;
    }

    void dfs(int[] cookies, int start, int k, int[] temp) {
        if (start == cookies.length) {
            int max = 0;
            for (int num : temp) {
                max = Math.max(max, num);
            }
            result = Math.min(result, max);
            return;
        }

        for (int i = 0 ; i < k ; i++) {
            temp[i] += cookies[start];
            dfs(cookies, start + 1, k, temp);
            temp[i] -= cookies[start];
        }
    }
}