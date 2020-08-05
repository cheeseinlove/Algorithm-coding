import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-30 09:13
 * @Description:
 */
public class Interview0204 {


    public ListNode partition(ListNode head, int x) {
        ListNode leftDummy = new ListNode(-1);
        ListNode left = leftDummy;
        ListNode rightDummy = new ListNode(-1);
        ListNode right = rightDummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                left.next = cur;
                left = left.next;
            } else {
                right.next = cur;
                right = right.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        left.next = rightDummy.next;
        rightDummy.next = null;
        return leftDummy.next;
    }
}


