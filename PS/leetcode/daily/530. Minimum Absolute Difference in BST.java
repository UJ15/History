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
    private int result;
    private int prev;

    public int getMinimumDifference(TreeNode root) {
        result = Integer.MAX_VALUE;
        prev = Integer.MAX_VALUE;

        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            dfs(root.left);
        }

        result = Math.min(result, Math.abs(prev - root.val));
        prev = root.val;

        if (root.right != null) {
            dfs(root.right);
        }
    }
}