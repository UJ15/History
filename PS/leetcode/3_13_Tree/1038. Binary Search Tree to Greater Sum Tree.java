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
    private int val;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }

        bstToGst(root.right);
        val += root.val;
        root.val = val;
        bstToGst(root.left);

        return root;
    }
}