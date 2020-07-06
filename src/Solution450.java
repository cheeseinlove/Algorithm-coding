import tools.TreeNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-01 09:42
 * @Description:
 */
public class Solution450 {
    public int rightMin(TreeNode root) {//1.找到以某个结点为根节点的右子树最小值。
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    public int leftMax(TreeNode root) {//2.找到以某个结点为根节点的左子树最大值。
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {//3.递归终止条件
            return null;
        }
        if (key > root.val) {//4.如果查找的结点比根节点大，继续在右子树查找删除该结点
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {//5.如果查找的结点比根节点小，继续在左子树查找删除该结点
            root.left = deleteNode(root.left, key);
        } else {//6.如果找到了该结点，删除它
            if (root.left == null && root.right == null) {//7.以叶子节点为根节点的二叉搜索树只有一个元素，可以直接删除。
                root = null;
            } else if (root.right != null) {//8.如果有右子树，只要找到该右子树的最小值来替换，之后将它删除即可。
                root.val = rightMin(root);
                root.right = deleteNode(root.right, root.val);//9.将这个右子树的最小值替换根节点，此时存在两个相同节点，将这个节点删除即可。
            } else {//10.如果有左子树，只要找到该左子树的最大值来替换，之后将它删除即可。
                root.val = leftMax(root);
                root.left = deleteNode(root.left, root.val);//9.将这个左子树的最大值替换根节点，此时存在两个相同节点，将这个节点删除即可。
            }
        }
        return root;
    }
}
