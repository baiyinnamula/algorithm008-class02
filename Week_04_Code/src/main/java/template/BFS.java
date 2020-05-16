package template;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 广度优先遍历（需要使用一个队列）
 */
public class BFS {
    Set<TreeNode> visited = new HashSet<>();
    public void bfs(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            TreeNode parent = queue.poll();
            visited.add(parent);
            if (parent.left != null){
                queue.add(parent.left);
            }
            if (parent.right != null){
                queue.add(parent.right);
            }
        }
    }
}
