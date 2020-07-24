import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-20 09:11
 * @Description:
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }

        ListNode fast=head;
        ListNode slow=head;

        while (slow!=null){
            if (fast==null||fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }
}
