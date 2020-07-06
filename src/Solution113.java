import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-01 13:33
 * @Description:
 */

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root!=null)
        dfs(root, sum, 0, ans, new ArrayList<>());
        return ans;
    }

    public void dfs(TreeNode root, int target, int sum, List<List<Integer>> ans, List<Integer> path) {
        path.add(root.val);
        List<Integer> leftPath = new ArrayList<>(path);
        List<Integer> rightPath = new ArrayList<>(path);
        int newSum = sum + root.val;
        if (root.left == null && root.right == null) {
            if (sum == target) {
                ans.add(path);
            }
        }
        if (root.left != null) {
            dfs(root.left, target, newSum, ans, leftPath);
        }
        if (root.right != null) {
            dfs(root.right, target, newSum, ans, rightPath);
        }
    }
}
