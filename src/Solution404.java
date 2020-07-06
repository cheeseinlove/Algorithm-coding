import tools.TreeNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-02 23:49
 * @Description:
 */
public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
    return dfs(root,false);
    }
    public int dfs(TreeNode root, boolean isLeft){
        if (root==null){
            return 0;
        }
        if (root.left==null&&root.right==null){
            if (isLeft){
                return root.val;
            }else {
                return 0;
            }
        }
        return dfs(root.left,true)+dfs(root.right,false);

    }
}
