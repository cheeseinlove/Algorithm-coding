import tools.TreeNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-22 23:34
 * @Description:
 */
public class Solution236 {
    private TreeNode ans;

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (canFindNode(root.left, p) && canFindNode(root.left, q)) {
                if (root.left==p||root.left==q){
                    return root.left;
                }
                root = root.left;
            } else if (canFindNode(root.right, q) && canFindNode(root.right, p)) {
                if (root.right==p||root.right==q){
                    return root.right;
                }
                root = root.right;
            } else {
                return root;
            }

        }
    }

    //判断node在不在root子树中
    public boolean canFindNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root==node){
            return true;
        }
        if (root.right == node || root.left == node) {
            return true;
        }
        return canFindNode(root.left, node) || canFindNode(root.right, node);

    }
    public static TreeNode getLastCommonParentRec2(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) {
            return null;
        }
        // 如果有一个match，则说明当前node就是要找的最低公共祖先
        if (root.equals(n1) || root.equals(n2)) {
            return root;
        }
        TreeNode commonLeft = getLastCommonParentRec2(root.left, n1, n2);
        TreeNode commonRight = getLastCommonParentRec2(root.right, n1, n2);
        // 如果一个在左子树找到，一个在右子树找到，则说明root是唯一可能得最低公共祖先
        if (commonLeft != null && commonRight != null) {
            return root;
        }
        // 其他情况是要不然在左子树要不然在右子树
        if (commonLeft != null) {
            return commonLeft;
        }
        return commonRight;
    }

}
