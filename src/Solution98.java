import tools.TreeNode;

import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-24 21:08
 * @Description:
 */
public class Solution98 {

    public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack();
            double inorder = - Double.MAX_VALUE;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
                if (root.val <= inorder) return false;
                inorder = root.val;
                root = root.right;
            }
            return true;


    }
}
