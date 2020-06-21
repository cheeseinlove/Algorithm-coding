import tools.TreeNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-21 08:11
 * @Description:
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
     if (root==null){
         return 0;
     }
        return Math.max(dfs(root.left,1),dfs(root.right,1));

    }

    public  int dfs(TreeNode root,int depth){
        if (root==null){
            return depth;
        }
        return Math.max(dfs(root.left,depth+1),dfs(root.right,depth+1));
    }
}
