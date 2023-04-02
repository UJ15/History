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
    int longest;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);

        return longest;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {0, -1001};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);


        if (left[1] != root.val) {
            left[0] = 0;
        }

        if (right[1] != root.val) {
            right[0] = 0;
        }

        longest = Math.max(longest, left[0] + right[0]);

        return new int[] {Math.max(left[0], right[0]) + 1, root.val};
    }
}