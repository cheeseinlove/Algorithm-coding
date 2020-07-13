import tools.TreeNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-13 09:16
 * @Description:
 */
public class Solution814 {
    public TreeNode pruneTree(TreeNode root) {
        isAllZero(root);

        return root;
    }
    public boolean isAllZero(TreeNode root){
        if (root==null){
            return true;
        }
        boolean deleteLeft=isAllZero(root.left);
        boolean deleteRight=isAllZero(root.right);

        if (deleteLeft){
            root.left=null;
        }
        if (deleteRight){
            root.right=null;
        }
        if (deleteLeft&&deleteRight&&root.val==0){
            return true;
        }
        return false;
    }
}
