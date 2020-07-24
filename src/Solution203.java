import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-22 23:28
 * @Description:
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head==null){
            return null;
        }
      ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=head;
        while (cur!=null){
            if (cur.val==val){
                pre.next=cur.next;
                cur=cur.next;
            }else {
                pre=pre.next;
                cur=cur.next;
            }

        }

        return dummy.next;
    }
}
