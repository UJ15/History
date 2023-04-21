/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int max;

    public int longestZigZag(TreeNode root) {
        max = 0;

        dfs(root, 0, 0);

        return max;
    }

    private void dfs(TreeNode root, int depth, int flag) {
        if (root == null) {
            return;
        }

        max = Math.max(max, depth);

        if (flag == 0) {
            dfs(root.left, depth + 1, -1);
            dfs(root.right, depth + 1, 1);
        } if (flag == -1) {
            dfs(root.right, depth + 1 , 1);
            dfs(root.left, 1, -1);
        } else {
            dfs(root.left, depth + 1, -1);
            dfs(root.right, 1, 1);
        }
    }
}

/**
 * 불필요한 코드 개선 (속도빨라짐)
 *
 */

class Solution {
    private int max;

    public int longestZigZag(TreeNode root) {
        max = 0;

        dfs(root.left, 1, true);
        dfs(root.right, 1, false);

        return max;
    }

    private void dfs(TreeNode root, int depth, boolean flag) {
        if (root == null) {
            return;
        }

        max = Math.max(max, depth);

        if (flag) {
            dfs(root.right, depth + 1 , false);
            dfs(root.left, 1, true);
        } else {
            dfs(root.left, depth + 1, true);
            dfs(root.right, 1, false);
        }
    }
}