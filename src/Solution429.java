import tools.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-01 13:18
 * @Description:
 */

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其层序遍历:[
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 */
public class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue=new LinkedList<>();
        if (root!=null){
            queue.offer(root);
        }
        List<List<Integer>> ans=new ArrayList<>();
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> sameLevel=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node node=queue.poll();
                sameLevel.add(node.val);
                for(Node child:node.children){
                    if (child!=null){
                        queue.offer(child);
                    }
                }
            }
            ans.add(sameLevel);
        }
        return ans;
    }
}
