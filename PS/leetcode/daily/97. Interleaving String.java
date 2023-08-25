import java.util.Stack;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        Stack<int[]> stack = new Stack<int[]>();
        stack.push(new int[] {0, 0});

        boolean[][] visited = new boolean[s1.length() + 1][s2.length() + 1];

        while (!stack.empty()) {
            int[] indexes = stack.pop();
            int i = indexes[0], j = indexes[1];
            visited[i][j] = true;

            if (i == s1.length() && j == s2.length())
                return true;

            if (i < s1.length() && !visited[i + 1][j] && s1.charAt(i) == s3.charAt(i + j))
                stack.push(new int[] {i + 1, j});

            if (j < s2.length() && !visited[i][j + 1] && s2.charAt(j) == s3.charAt(i + j))
                stack.push(new int[] {i, j + 1});
        }

        return false;
    }
}