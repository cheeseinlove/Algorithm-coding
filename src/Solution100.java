import tools.TreeNode;

/**
 * @Author liuxun05
 * @create 2020/6/21 21:01
 **/
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if (p==null&&q==null){
          return true;
      }
      if (p==null||q==null){
          return false;
      }
      if (p.val!=q.val){
          return false;
      }
      return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
