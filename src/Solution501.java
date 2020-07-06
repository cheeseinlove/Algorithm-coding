import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-02 09:30
 * @Description:
 */
public class Solution501 {
    private List<Integer> items=new ArrayList<>();
    private int maxCount=Integer.MIN_VALUE;
    private TreeNode pre;
    private  int curCount;
    public int[] findMode(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if (pre!=null&&root.val==pre.val){
                curCount++;
            }else {
                curCount=1;
            }
            if (curCount==maxCount){
                items.add(root.val);
            }
            if (curCount>maxCount){
                maxCount=curCount;
                items.clear();
                items.add(root.val);
            }
            pre=root;
            root=root.right;
        }
        int[] res = new int[items.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = items.get(i);
        return res;

    }
}
