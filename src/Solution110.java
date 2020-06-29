import tools.TreeNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-23 10:27
 * @Description:
 */
public class Solution110 {
    private boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
     isBalanced=true;
     getHeight(root);
     return isBalanced;
    }
    public int getHeight(TreeNode root){
        if (root==null){
            return 0;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        if (leftHeight-rightHeight>1||rightHeight-leftHeight>1){
            isBalanced=false;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
}
