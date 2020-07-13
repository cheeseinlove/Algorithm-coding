import tools.TreeNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-07 10:26
 * @Description:
 */
public class Solution543 {
    private int max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        recursion(root);
        return max-1;
    }

    public int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recursion(root.left);
        int right = recursion(root.right);
        int curMax = 1 + Math.max(left, right);
        max = Math.max(max,  1+left + right);
        return curMax;
    }
}
