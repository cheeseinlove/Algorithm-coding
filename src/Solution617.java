import tools.TreeNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-23 21:37
 * @Description:
 */
public class Solution617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int val = 0;
        TreeNode t1l=null;
        TreeNode t1r=null;
        TreeNode t2l=null;
        TreeNode t2r=null;
        if (t1 != null) {
            val += t1.val;
            t1l=t1.left;
            t1r=t1.right;
        }
        if (t2 != null) {
            val += t2.val;
            t2l=t2.left;
            t2r=t2.right;
        }
        TreeNode node = new TreeNode(val);
        node.left = mergeTrees(t1l, t2l);
        node.right = mergeTrees(t1r, t2r);
        return node;
    }
}
