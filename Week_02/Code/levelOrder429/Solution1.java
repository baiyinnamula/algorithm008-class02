package levelOrder429;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {

        if (root != null) {
            helper(root, 0);
        }
        return res;
    }

    private void helper(Node root, int level) {
        if (res.size() <= level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        for (Node child : root.children) {
            helper(child, level + 1);
        }
    }
}
