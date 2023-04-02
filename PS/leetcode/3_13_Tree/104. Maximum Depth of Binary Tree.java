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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        max = 0;

        dfs(root, 1);

        return max;
    }

    public void dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            max = Math.max(max, depth);
        }

        if (root.left != null) {
            dfs(root.left, depth + 1);
        }

        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
    }
}

/**
 * 한줄 코드
 *
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}