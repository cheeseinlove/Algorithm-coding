/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-29 21:00
 * @Description:
 */

import tools.TreeNode;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1

 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.right); // 递归镜像左右子树
        TreeNode right = invertTree(root.left);
        root.left = left; // 更新根节点的左右子树为镜像后的树
        root.right = right;
        return root;

    }
//    public TreeNode exchangeValue(TreeNode left,TreeNode right){
//        if (left==null&&right==null){
//            return ;
//        }
//        if (left==null){
//            return ;
//
//        }
//        if (right==null){
//            return ;
//        }
//        int temp=left.val;
//        left.val=right.val;
//        right.val=temp;
//        exchangeValue(left.left,right.right);
//        exchangeValue(left.right,right.left);
//    }
}
