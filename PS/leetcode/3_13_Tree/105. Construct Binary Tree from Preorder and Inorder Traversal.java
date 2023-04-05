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

/**
 * 전위, 중위, 후위 순회 결과 리스트(배열)중 2가지만 있다면 이진 트리를 복원이 가능하다.
 * 전위 순회는 곧 루트 노드의 순서다.
 * 전위 순회 리스트 맨 앞 인덱스를 가져오면서 해당 값의 중위 순회 리스트 인덱스 기준 왼쪽 서브트리와 오른쪽 서브트리로 나뉜다.
 * 이를 재귀로 구현하면 복원이 된다.
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return dfs(IntStream.of(preorder).boxed().collect(Collectors.toList()),
                IntStream.of(inorder).boxed().collect(Collectors.toList()));
    }

    private TreeNode dfs(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.size() == 0 || inorder.size() == 0) {
            return null;
        }

        int index = inorder.indexOf(preorder.remove(0));

        TreeNode root = new TreeNode(inorder.get(index));
        root.left = dfs(preorder, inorder.subList(0, index));
        root.right = dfs(preorder, inorder.subList(index + 1, inorder.size()));

        return root;
    }


}