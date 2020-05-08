package invertTree226;

public class Solution1 {
    public TreeNode invertTree(TreeNode root) {
        //terminator
        if (root == null) {
            return null;
        }
        //drill down && process current logic
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);

        return root;
    }
}
