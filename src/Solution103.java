import tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-20 23:26
 * @Description:
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (queue.size() != 0) {
            int size = queue.size();
            List<Integer> nodeVal = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (ans.size()%2==0){
                   ((LinkedList<Integer>) nodeVal).addLast(node.val);
                }else {
                    ((LinkedList<Integer>) nodeVal).addFirst(node.val);

                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(nodeVal);
        }


        return ans;
    }
}
