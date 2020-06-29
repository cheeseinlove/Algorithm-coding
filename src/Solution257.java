import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-24 16:09
 * @Description:
 */
public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans =new ArrayList<>();
        if (root!=null)
        dfs(root,new StringBuilder(),ans);
        return ans;
    }

    public void dfs(TreeNode root,StringBuilder sb,List<String> ans){
        sb.append(root.val);
        sb.append("->");
        if (root.left==null&&root.right==null){
            //删一个多的->
            sb.deleteCharAt(sb.length()-1);
            ans.add(sb.toString());
            return;
        }
        StringBuilder temp=new StringBuilder(sb);
        if (root.left!=null){
            dfs(root.left,sb,ans);
        }
        if (root.right!=null) {
            dfs(root.right, temp, ans);
        }
    }
}
