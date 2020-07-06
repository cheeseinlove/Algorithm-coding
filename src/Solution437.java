/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-01 13:33
 * @Description:
 */

import tools.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution437 {
    private int ans=0;
    public int pathSum(TreeNode root, int sum) {
        if (root!=null){
            dfs(new ArrayList<>(),sum,root);
        }
        return ans;
    }
    public void dfs(List<Integer> path, int target, TreeNode root){
        if (root==null){
            return ;
        }
        if (root.val==target){
            ans++;
        }
        for(int i=0;i<path.size();i++){
            int temp=path.get(i);
            if (temp==target-root.val){
                ans++;
            }
            path.set(i,temp+root.val);
        }
        path.add(root.val);
        List<Integer> rightPath=new ArrayList<>(path);
        dfs(path,target,root.left);
        dfs(rightPath,target,root.right);
    }

    public int pathSum2(TreeNode root, int sum) {
        if (root!=null){
            //key为到当前节点的路径和，value为出现次数，前缀和思想
            Map<Integer,Integer> map=new HashMap<>();
            map.put(0,1);
            dfs2(map,sum,root,0);
        }
        return ans;
    }
    public void dfs2(Map<Integer,Integer> path,int target,TreeNode root,int curSum){
        if (root==null){
            return ;
        }
        curSum+=root.val;
        if (path.containsKey(curSum-target)){
            ans+=path.get(curSum-target);
        }
        path.put(curSum,path.getOrDefault(curSum,0)+1);
        Map<Integer,Integer> rightPath=new HashMap<>(path);
        dfs2(path,target,root.left,curSum);
        dfs2(rightPath,target,root.right,curSum);

    }
}
