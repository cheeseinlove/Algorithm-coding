import tools.ListNode;
import tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-31 09:35
 * @Description:
 */
public class Solution1367 {
//    public boolean isSubPath(ListNode head, TreeNode root) {
//
//        return dfs(head, root);
//    }
//
//    public boolean dfs(ListNode cur, TreeNode root) {
//        if (cur == null) {
//            return true;
//        }
//        if (root == null) {
//            return false;
//        }
//
//        boolean leftFlag = false;
//        boolean rightFlag = false;
//        if (root.val == cur.val) {
//            leftFlag = dfs(cur.next, root.left);
//            rightFlag = dfs(cur.next, root.right);
//        }
//        boolean leftFlag2 = dfs(cur, root.left);
//        boolean rightFlag2 = dfs(cur, root.right);
//        boolean ans = leftFlag || rightFlag || leftFlag2 || rightFlag2;
//        return ans;
//    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null) return false;
        if (head.val == root.val) return isSubPathLoop(head.next, root.left) || isSubPathLoop(head.next, root.right) || isSubPath(head, root.left) || isSubPath(head, root.right);
        else return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean isSubPathLoop(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val == root.val)
            return isSubPathLoop(head.next, root.left) || isSubPathLoop(head.next, root.right);
        else
            //最重要就是这一步，这也是为什么要区分两个办法，如果是之前就匹配上了但是这次没匹配到就直接返回失败
            return false;
    }


}
