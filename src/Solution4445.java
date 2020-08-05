import tools.ListNode;

import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-27 23:15
 * @Description:
 */
public class Solution4445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null) {
            stack1.push(cur1);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            stack2.push(cur2);
            cur2 = cur2.next;
        }
        ListNode tail = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ListNode node1=null;
            ListNode node2=null;
            if(!stack1.isEmpty()){
                 node1 = stack1.pop();
            }
            if (!stack2.isEmpty()){
                 node2 = stack2.pop();
            }
            int newValue = 0;
            if (node1 != null) {
                newValue += node1.val;
            }
            if (node2 != null) {
                newValue += node2.val;
            }
            ListNode newNode = new ListNode((newValue + carry) % 10);
            carry = (newValue + carry) / 10;
            newNode.next = tail;
            tail = newNode;
        }
        if (carry > 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = tail;
            tail = newHead;
        }
        return tail;
    }
}
