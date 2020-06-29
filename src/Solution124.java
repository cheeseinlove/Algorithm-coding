import tools.TreeNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-22 13:19
 * @Description:
 */
public class Solution124 {
    private int max=Integer.MIN_VALUE;
    public static void main(String[] args) {

    }
    public int maxPathSum(TreeNode root) {
      if (root==null){
          return 0;
      }
      dfs(root);
      return max;
    }

    public int dfs(TreeNode root){
        int ans=0;
        if (root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        int leftMax=left>0?left:0;
        int rightMax=right>0?right:0;
        ans=root.val+Math.max(leftMax,rightMax);
        max=Math.max(max,root.val+leftMax+rightMax);
        return ans;
    }

}
