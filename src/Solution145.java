/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-30 09:21
 * @Description:
 */

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution145 {
    List<Integer> ans;
    public List<Integer> postorderTraversal(TreeNode root) {
         ans=new ArrayList<>();
        traversal(root);
        return ans;
    }
    public void traversal(TreeNode root){
        if (root==null){
            return ;
        }
        traversal(root.left);
        traversal(root.right);
        ans.add(root.val);
    }
}
