/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-24 08:59
 * @Description:
 */

import java.util.Stack;

/**
 * @Description: 1---2---3---4---5---6--NULL
 * |
 * 7---8---9---10--NULL
 * |
 * 11--12--NULL
 * 序列化其中的每一级之后：
 * <p>
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * 为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。
 * <p>
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * 合并所有序列化结果，并去除末尾的 null 。
 * <p>
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @return
 * @throws
 */
public class Solution430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node prev = new Node();
        prev.next = head;
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {//有child
                if (curr.next != null) //如果当前层数的next不是null，才入栈
                    stack.push(curr.next);
                //双向连接child
                curr.next = curr.child;
                curr.next.prev = curr;
                curr.child = null;//清除child
            } else if (curr.next == null && !stack.isEmpty()) {//到当前层的最后一个节点且stack里有记录
                //双向连接上一层的下一个节点
                curr.next = stack.pop();
                curr.next.prev = curr;
            }
            curr = curr.next;
            prev = prev.next;
        }
        return head;

    }
}
