import tools.TreeNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-12 08:44
 * @Description:
 */
public class Solution606 {
    //前序遍历
    TreeNode pre = null;

    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        helper(t, pre, sb);
        return sb.substring(1, sb.length() - 1);
    }

    private void helper(TreeNode root, TreeNode pre, StringBuilder sb) {
        if (root == null) return;
        //前序遍历
        //1.如果当前节点为父节点的右子树且左子树为空，括号不能省略
        if (pre != null && pre.left == null && pre.right == root) {
            sb.append("()");
        }
        sb.append("(").append(root.val);
        pre = root;
        helper(root.left, pre, sb);
        helper(root.right, pre, sb);
        //遍历完当前节点后关闭括号
        sb.append(")");
    }


}
