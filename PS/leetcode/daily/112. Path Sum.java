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
    private boolean result;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        result = false;

        dfs(root, targetSum);

        return result;
    }

    public void dfs(TreeNode root, int t) {
        if (result || root == null) {
            return;
        }

        t -= root.val;

        if (t == 0 && root.left == null && root.right == null) {
            result = true;
            return;
        }

        dfs(root.left, t);
        dfs(root.right, t);
    }
}