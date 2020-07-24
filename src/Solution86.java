import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-16 23:37
 * @Description:
 */
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head==null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode less = dummy;
        ListNode moreDummy = new ListNode(-1);
        ListNode more = moreDummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                less.next = cur;
                less = less.next;
            } else {
                more.next = cur;
                more = more.next;
            }
            cur=cur.next;
        }
        //断尾防止成环 1，3，5，6，2 x=3
        more.next=null;
        //合并
        less.next = moreDummy.next;
        return dummy.next;


    }
}
