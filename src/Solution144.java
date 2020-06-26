import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-21 09:28
 * @Description:
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                ans.add(root.val);
                stack.push(root);
                root=root.left;
            }
            TreeNode cur=stack.pop();

            root=cur.right;
        }

        return ans;
    }
}
