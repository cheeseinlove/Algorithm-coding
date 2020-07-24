import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-21 23:42
 * @Description:
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

     if (headA==null||headB==null){
         return null;
     }

     ListNode pa=headA;
     ListNode pb=headB;

     while (pa!=pb){
         if (pa==null){
             pa=headB;
         }else {
             pa=pa.next;
         }
         if (pb==null){
             pb=headA;
         }else {
             pb=pb.next;
         }
     }
     return pa;

    }
}
