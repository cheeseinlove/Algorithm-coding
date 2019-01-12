import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;

/*
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */
public class BinaryTreeRightSideView {
    private  static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public static  int getDepth(TreeNode root){
if(root==null)
    return  0;
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
}
  public static void main(String...args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.right=new TreeNode(5);
        root.right=new TreeNode(3);
        root.right.right=new TreeNode(4);
System.out.println(getDepth(root));

  }
}
