import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-04 09:39
 * @Description:
 */
public class Interview0202 {
    public int kthToLast(ListNode head, int k) {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null){
            fast=fast.next;
            if (k==0){
                slow=slow.next;
            }else {
                k--;
            }
        }
        return slow.val;
    }
}
