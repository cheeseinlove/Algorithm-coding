import tools.TreeNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-22 09:43
 * @Description:
 */
public class Solution108 {
    public static void main(String[] args) {


    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        int midIndex = len / 2;
        TreeNode root = new TreeNode(nums[midIndex]);

        root.left = buildNode(nums, 0, midIndex - 1);
        root.right = buildNode(nums, midIndex + 1, len - 1);
        return root;
    }

    public  TreeNode buildNode(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int mid = begin + (end - begin) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildNode(nums, begin, mid - 1);
        root.right = buildNode(nums, mid + 1, end);
        return root;

    }
}
