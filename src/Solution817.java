import tools.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-28 23:21
 * @Description:
 */
public class Solution817 {
    public int numComponents(ListNode head, int[] G) {
        if (head==null){
            return 0;
        }
        Set<Integer> target=new HashSet<>();
        for(int i:G){
            target.add(i);
        }
        int ans=0;
        ListNode cur=head;
        while (cur!=null){
            if (target.contains(cur.val)){
                ans++;
                while (cur.next!=null&&target.contains(cur.next.val)){
                    cur=cur.next;
                }
            }
            cur=cur.next;
        }


        return ans;

    }
}
