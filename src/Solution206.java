import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-23 09:38
 * @Description:
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
