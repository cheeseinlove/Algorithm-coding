import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-03 20:26
 * @Description:
 */
public class Solution513 {
    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                if (i==0){
                    ans=node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }
}
