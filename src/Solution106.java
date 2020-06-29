import tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-23 10:27
 * @Description:
 */
public class Solution106 {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len != postorder.length) {
            return null;
        }
        indexMap = new HashMap<>(len);
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return getNode(inorder, postorder, 0, len - 1, 0, len - 1);
    }

    public TreeNode getNode(int[] inorder, int[] postorder, int pBegin, int pEnd, int iBegin, int iEnd) {
        if (pBegin > pEnd || iBegin > iEnd) {
            return null;
        }
        int rootVal = postorder[pEnd];
        int rootIndex = indexMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftSize = rootIndex - iBegin;
        int rightSize = iEnd - rootIndex;

        TreeNode left = getNode(inorder, postorder, pBegin, pBegin + leftSize - 1, iBegin, rootIndex - 1);
        TreeNode right = getNode(inorder, postorder, pBegin + leftSize, pEnd - 1, rootIndex + 1, iEnd);

        root.left = left;
        root.right = right;

        return root;
    }


}
