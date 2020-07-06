import tools.TreeNode;

import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-03 09:29
 * @Description:
 */
public class Solution530 {
    private int res = Integer.MAX_VALUE;
    private int pre = Integer.MAX_VALUE;

//    public int getMinimumDifference(TreeNode root) {
//        int ans = Integer.MAX_VALUE;
//        int pre = Integer.MAX_VALUE;
//        Stack<TreeNode> stack = new Stack<>();
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if (pre != Integer.MAX_VALUE) {
//                ans = Math.min(ans, root.val - pre);
//            }
//            pre = root.val;
//            root = root.right;
//        }
//
//        return ans;
//    }

    public int getMinimumDifference(TreeNode root) {
            inOrderTraverse(root);
            return res;
    }

    public void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left);
        if (pre != Integer.MAX_VALUE) {
            res=Math.min(res,root.val-pre);
        }
        pre=root.val;
        inOrderTraverse(root.right);

    }
}
