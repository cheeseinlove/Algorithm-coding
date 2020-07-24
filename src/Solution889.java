import tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-14 08:57
 * @Description:
 */
public class Solution889 {
    private static Map<Integer, Integer> index;

    public static void main(String[] args) {
        int pre[] = new int[]{1, 2, 4, 5, 3, 6, 7};
        int post[] = new int[]{4, 5, 2, 6, 7, 3, 1};
        constructFromPrePost(pre,post);
    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length < 1) {
            return null;
        }
        index = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            index.put(post[i], i);
        }

        return getNode(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    public static TreeNode getNode(int[] pre, int[] post, int preLeft, int preRight, int postLeft, int postRight) {
        if (preLeft > preRight || postRight < postLeft) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        if (preLeft == preRight) {
            return root;
        }
        int postLastLeftNodeIndex = index.get(pre[preLeft + 1]);
        int size = postLastLeftNodeIndex - postLeft + 1;
        root.left = getNode(pre, post, preLeft + 1, preLeft + size, postLeft, postLeft + size - 1);
        root.right = getNode(pre, post, preLeft + size + 1, preRight, postLeft + size, postRight - 1);
        return root;
    }
}
