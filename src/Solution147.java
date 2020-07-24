import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-21 21:29
 * @Description:
 */
public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
       if (head==null){
           return null;
       }
       ListNode dummy=new ListNode(-1);
       dummy.next=head;
       ListNode pre=head;
       ListNode cur=head.next;
       while (cur!=null){
           if (pre.val<=cur.val){
               pre=cur;
               cur=cur.next;
           }else {
               ListNode temp=cur.next;
               pre.next=null;
               ListNode p=dummy;
               //找到p<cur<p.next
               while(p.next!=null&&p.next.val<cur.val){
                   p=p.next;
               }
               cur.next=p.next;
               p.next=cur;
               cur=temp;
               pre.next=cur;
           }


       }



       return dummy.next;
    }
}
