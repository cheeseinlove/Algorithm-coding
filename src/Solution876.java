import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-03 22:35
 * @Description:
 */
public class Solution876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.next;
    }
}
