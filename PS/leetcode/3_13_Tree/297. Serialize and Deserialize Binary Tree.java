/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list.toString();
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode current = q.poll();

            if (current == null) {
                list.add("null");
                continue;
            } else {
                list.add(String.valueOf(current.val));
            }
            q.offer(current.left);
            q.offer(current.right);
        }

        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "[]") {
            return null;
        }
        String[] arr = data.substring(1, data.length() - 1).split(", ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        int index = 1;

        while (!q.isEmpty()) {
            TreeNode current = q.poll();

            if (!arr[index].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(arr[index]));
                q.offer(current.left);
            }
            index++;

            if (!arr[index].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(arr[index]));
                q.offer(current.right);
            }
            index++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));