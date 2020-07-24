import tools.TreeNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-14 23:43
 * @Description:
 */
public class Solution865 {


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left == right) {
            return root;
        } else if (left > right) {
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }

    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);


        return 1 + Math.max(left, right);
    }


}