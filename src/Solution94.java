import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-21 09:28
 * @Description:
 */
public class Solution94 {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        node1.right=node2;
        node2.left=node3;
        List<Integer> ans= inorderTraversal(node1);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode cur=stack.pop();

            ans.add(cur.val);
            root=cur.right;
        }

        return ans;
    }
}
