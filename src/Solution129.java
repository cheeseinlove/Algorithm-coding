import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-24 16:06
 * @Description:
 */
public class Solution129 {
    private int ans;

    public int sumNumbers(TreeNode root) {
        if (root != null) {
            dfs(root, 0);
        }
        return ans;

    }

    public void dfs(TreeNode root, int sum) {
        sum=sum*10+root.val;
        if (root.left == null && root.right == null) {
            ans += sum;
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum);
        }
        if (root.right != null) {
            dfs(root.right, sum);
        }
    }
}