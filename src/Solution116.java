import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-23 10:27
 * @Description:
 */
public class Solution116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        Queue<Node> queue=new LinkedList<>();
        if (root!=null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            int size=queue.size();
            Node pre= null;
            for(int i=0;i<size;i++){
                Node node=queue.poll();
                if (pre!=null) {
                    pre.next = node;
                }
                pre=node;
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
