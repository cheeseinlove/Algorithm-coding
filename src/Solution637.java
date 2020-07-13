import tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-09 09:30
 * @Description:
 */
public class Solution637 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        TreeNode root2=new TreeNode(9);
        TreeNode root3=new TreeNode(20);
        TreeNode root4=new TreeNode(15);
        TreeNode root5=new TreeNode(7);
        root.left=root2;
        root.right=root3;
        root3.left=root4;
        root3.right=root5;
        averageOfLevels(root);
    }
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (queue.size() > 0) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(sum / size);
        }
        return ans;
    }
}
