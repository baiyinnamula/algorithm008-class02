package preorder589;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<Node>();
        List<Integer> output = new LinkedList<Integer>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }
}
