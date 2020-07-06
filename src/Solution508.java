import tools.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-02 21:06
 * @Description:
 */
public class Solution508 {
    private static Map<Integer, Integer> cache = new HashMap<>();
    private static List<Integer> maxSum = new ArrayList<>();
    private static int maxCount = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        TreeNode left=new TreeNode(2);
        TreeNode right=new TreeNode(-3);
        root.left=left;
        root.right=right;
        int ans[]=findFrequentTreeSum(root);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
    public static int[] findFrequentTreeSum(TreeNode root) {
        if (root != null) {
            calculateSum(root);
        }
        int ans[] = new int[maxSum.size()];
        for (int i = 0; i < maxSum.size(); i++) {
            ans[i] = maxSum.get(i);
        }
        return ans;
    }

    public static int calculateSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = calculateSum(root.left);
        int right = calculateSum(root.right);
        int curSum = root.val + left + right;
        cache.put(curSum, cache.getOrDefault(curSum, 0) + 1);
        int curCount = cache.get(curSum);
        if (curCount > maxCount) {
            maxSum.clear();
            maxSum.add(curSum);
            maxCount = curCount;
        } else if (curCount == maxCount) {
            maxSum.add(curSum);
        }
        return curSum;

    }
}
