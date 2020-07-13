import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-10 09:19
 * @Description:
 */
public class Solution655 {
    public List<List<String>> printTree(TreeNode root) {
        int h = getHeight(root);
        int w = (1<<h ) -1 ; // 2^h -1  二叉树的最大宽度，也是字符串数组的长度

        List<List<String>> res = new ArrayList<>();
        //先将res全部置为“”
        for(int i = 0 ; i < h ; i ++) {
            List<String> item = new ArrayList<>();
            for(int j = 0 ; j < w ; j++)
                item.add("");
            res.add(item);
        }

        //填充数字
        fill(root, res, 0, 0, w-1);
        return res;
    }

    //返回二叉树的高度
    int getHeight(TreeNode root) {
        if(root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    /*
        实际上相当于是一个二分，在左子树去寻找相应的位置，满足
            根节点在区域中间，左孩子在左边的中间，右孩子在右边的中间
    */
    void fill(TreeNode node, List<List<String>> res , int h , int l , int r) {
        if(node == null) return;
        int mid = (l +r) /2;
        String s= res.get(h).get(mid);
        res.get(h).set(mid, Integer.toString(node.val));    //相应位置填上数字

        fill(node.left, res, h+1, l, mid-1);
        fill(node.right, res, h+1, mid+1, r);
    }


}
