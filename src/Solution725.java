import tools.ListNode;

import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-27 23:39
 * @Description:
 */
public class Solution725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int n = 0;
        ListNode cur = root;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        ListNode[] ans = new ListNode[k];
        if (n==0){
            return ans;
        }
        int part = n / k;
        int rem = n % k;
        cur = root;
        for (int i = 0; i < k; i++) {
            ListNode head = cur;
            int max = part;
            if (i < rem) {
                max += 1;
            }
            for (int j = 0; j < max - 1; j++) {
                cur = cur.next;
            }
            if (cur!=null){
                ListNode temp=cur.next;
                cur.next=null;
                cur=temp;
            }
            ans[i] = head;
        }


        return ans;

    }
}
