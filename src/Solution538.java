import tools.TreeNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-06 23:17
 * @Description:
 */
public class Solution538 {
    private int preSum = 0;

    public TreeNode convertBST(TreeNode root) {
        reverseInOrder(root);
        return root;
    }

    /**
     * @param root
     * @return void
     * @throws
     * @Description: 维护前缀和，反向中序遍历
     */
    public void reverseInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        reverseInOrder(root.right);
        preSum += root.val;
        root.val = preSum;
        reverseInOrder(root.left);
    }
}
