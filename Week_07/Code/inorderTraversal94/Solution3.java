package inorderTraversal94;

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路：莫里斯遍历
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution3 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null){
            //当前节点没有左子节点
            if (curr.left == null){
                ans.add(curr.val);
                //移到右子节点
                curr = curr.right;
            }else {
                pre = curr.left;
                //找左子节点的最右子节点
                while (pre.right != null){
                    pre = pre.right;
                }
                //将当前节点设置为最右子节点的右子节点
                pre.right = curr;
                TreeNode temp = curr;
                //当前指针指向原先左子节点
                curr = curr.left;
                //将原先节点的左子节点设置为null
                temp.left = null;
            }
        }
        return ans;
    }
}
