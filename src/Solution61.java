import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-15 21:15
 * @Description:
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
       if (head==null){
           return null;
       }
      int len=0;
      ListNode cur=head;
      //新头结点的前一个节点
      ListNode newBeginPre=head;

      while (cur!=null){
          cur=cur.next;
          len++;
      }
      k=k%len;
      if (k==0){
          return head;
      }
      cur=head;
      int step=len-1;
      //新环的倒数第k个节点即为新头结点
      for(int i=1;i<=step;i++){
          cur=cur.next;
          if (i>k){
              newBeginPre=newBeginPre.next;
          }

      }
      ListNode newBegin=newBeginPre.next;
      //连成环
      cur.next=head;
      //断尾
      newBeginPre.next=null;
      return newBegin;

    }
}
