import tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-06 09:55
 * @Description:
 */
public class Solution515 {
    public static void main(String[] args) {

    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if (root!=null){
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int max=Integer.MIN_VALUE;
                int size=queue.size();
                for(int i=0;i<size;i++){
                    TreeNode node=queue.poll();
                    max=Math.max(max,node.val);
                    if (node.left!=null){
                        queue.offer(node.left);
                    }
                    if(node.right!=null){
                        queue.offer(node.right);
                    }
                }
                ans.add(max);
            }
        }
        return ans;
    }
}
