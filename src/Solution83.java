import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-16 09:15
 * @Description:
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode cur = head;
        ListNode next = head;
        while (cur != null) {
            while (next!=null&&cur.val == next.val) {
                next = next.next;
            }
            cur.next = next;
            cur = cur.next;

        }
        return head;
    }
}
