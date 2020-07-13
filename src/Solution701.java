import tools.TreeNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-11 09:32
 * @Description:
 */
public class Solution701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root != null) {
            insert(root, val);
        }else {
            return new TreeNode(val);
        }
        return root;
    }

    public void insert(TreeNode root, int val) {

        if (root.val < val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            } else {
                insert(root.right, val);
            }
        } else {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            } else {
                insert(root.left, val);
            }
        }
    }
}