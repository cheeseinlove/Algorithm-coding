import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-31 20:37
 * @Description:
 */
public class InterView0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      if (l1==null){
          return l2;
      }
      if (l2==null){
          return l1;
      }

      ListNode dummy=new ListNode(0);
      ListNode tail=dummy;
      ListNode p1=l1;
      ListNode p2=l2;
      int next=0;
      while (p1!=null||p2!=null){
          int sum=next;
          if (p1!=null){
              sum+=p1.val;
              p1=p1.next;
          }
          if (p2!=null){
              sum+=p2.val;
              p2=p2.next;
          }
          next=sum/10;
          ListNode newNode=new ListNode(sum%10);
          tail.next=newNode;
          tail=tail.next;
      }

      if (next>0){
          tail.next=new ListNode(next);
      }
      return dummy.next;
    }
}
