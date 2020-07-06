import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-30 23:03
 * @Description:
 */
public class Solution449 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    sb.append(root.val + ",");
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;
            }
            if (sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        public String serialize2(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            helper(root, sb);
            if (sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        public void helper(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return;
            }
            sb.append(root.val + ",");
            helper(root.left, sb);
            helper(root.right, sb);
        }

        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) return null;
            String[] arr = data.split(",");
            return builder(arr, 0, arr.length - 1);
        }

        private TreeNode builder(String[] arr, int lo, int hi) {
            if (lo > hi) return null;
            TreeNode root = new TreeNode(Integer.valueOf(arr[lo]));
            //找到第一个比首元素大的元素位置,这个位置是右子树位置
            int index = hi + 1;
            for (int i = lo + 1; i <= hi; i++) {
                if (Integer.valueOf(arr[i]) > root.val) {
                    index = i;
                    break;
                }
            }
            //递归构建子树
            root.left = builder(arr, lo + 1, index - 1);
            root.right = builder(arr, index, hi);
            return root;
        }

    }

}
