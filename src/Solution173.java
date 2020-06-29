import tools.TreeNode;

import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-24 21:22
 * @Description:
 */
public class Solution173 {
    class BSTIterator {
        Stack<TreeNode> stack;
        TreeNode root;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            if (root != null) {
                this.root = root;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            int ans = root.val;
            if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
            return ans;

        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
         if (root==null&&stack.isEmpty()){
             return false;
         }
         return true;
        }
    }
}
