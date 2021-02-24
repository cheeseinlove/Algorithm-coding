package week_competition;

import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-11 09:10
 * @Description:
 */
public class Solution5652 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast=head;
        ListNode slow=head;
        ListNode first=null;
        for(int i=0;i<k;i++){
            if (i==k-1){
                first=fast;
            }
            fast=fast.next;

        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        int temp=slow.val;
        slow.val=first.val;
        first.val=temp;
        return head;
    }
}
