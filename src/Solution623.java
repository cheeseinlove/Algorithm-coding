import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-07 23:32
 * @Description:
 */
public class Solution623 {
    public TreeNode addOneRow(TreeNode t, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = t;
            return n;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(t);
        int depth = 1;
        while (depth < d - 1) {
            Queue<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }
            queue = temp;
            depth++;
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            TreeNode temp = node.left;
            node.left = new TreeNode(v);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(v);
            node.right.right = temp;
        }
        return t;
    }

}
