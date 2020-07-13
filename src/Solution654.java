import tools.TreeNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-08 09:10
 * @Description:
 */
public class Solution654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getNode(nums, 0, nums.length - 1);
    }

    public TreeNode getNode(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = getNode(nums, left, maxIndex - 1);
        root.right = getNode(nums, maxIndex + 1,right );
        return root;
    }
}
