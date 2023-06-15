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
    private int len;
    public int maxLevelSum(TreeNode root) {
        int[] arr = new int[100000];
        len = 0;
        dfs(root, arr, 0);

        int[] max = new int[2];
        max[0] = Integer.MIN_VALUE;

        for (int i = 0 ; i < len ; i++) {
            if (arr[i] > max[0]) {
                max[0] = arr[i];
                max[1] = i;
            }
        }

        return max[1] + 1;
    }

    private void dfs(TreeNode root, int[] arr, int index) {
        if (root == null) {
            len = Math.max(index, len);
            return;
        }

        arr[index] += root.val;

        dfs(root.left, arr, index + 1);
        dfs(root.right, arr, index + 1);
    }
}
