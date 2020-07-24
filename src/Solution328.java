import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-24 08:17
 * @Description:
 */
public class Solution328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode dummy = head.next;
        ListNode even = head.next;
        while (odd.next != null && odd.next.next != null) {
            ListNode oddNext = odd.next.next;
            ListNode evenNext = even.next.next;
            odd.next = oddNext;
            even.next = evenNext;
            odd = oddNext;
            even = evenNext;
        }
        odd.next = dummy;
        return head;
    }
}
