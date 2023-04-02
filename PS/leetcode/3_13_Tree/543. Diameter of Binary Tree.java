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
    private int distance;

    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);
        return distance;
    }

    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }

        int left = 0;
        int right = 0;

        if (root.left == null) {
            left -= 1;
        }

        if (root.right == null) {
            right -= 1;
        }

        if (root.left != null) {
            left = dfs(root.left);
        }

        if (root.right != null) {
            right = dfs(root.right);
        }

        distance = Math.max(distance, left + right + 2);

        return Math.max(left, right) + 1;
    }
}