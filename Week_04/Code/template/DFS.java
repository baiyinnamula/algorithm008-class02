package template;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {
    Set<TreeNode> visited = new HashSet<>();

    /**
     * 深度优先遍历（递归）
     *
     * @param node
     */
    public void recursiveDfs(TreeNode node) {
        if (node == null || visited.contains(node)) {
            return;
        }
        visited.add(node);
        if (node.left != null) {
            recursiveDfs(node.left);
        }
        if (node.right != null) {
            recursiveDfs(node.right);
        }
    }

    /**
     * 深度优先遍历（非递归）:需要自己维护一个栈
     *
     * @param node
     */
    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode parent = stack.pop();
            visited.add(parent);
            if (parent.left != null) {
                stack.push(parent.left);
            }
            if (parent.right != null) {
                stack.push(parent.right);
            }
        }
    }
}
