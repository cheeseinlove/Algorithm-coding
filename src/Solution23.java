import tools.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/*
leetcode 23
 */
public class Solution23 {
    public static ListNode mergeKLists(ListNode[] lists) {
//        ListNode head = new ListNode(0);
//        ListNode cur = head;
//        if (lists.length!=0) {
//            int count = 0;
//            while (count != lists.length) {
//
//                int temp = -1;
//                int min = Integer.MAX_VALUE;
//                for (int i = 0; i < lists.length; i++) {
//                    if (lists[i] != null && lists[i].val < min) {
//                        temp = i;
//                        min = lists[temp].val;
//                    }
//                }
//                if (temp==-1)
//                    break;
//                cur.next =new ListNode(lists[temp].val);
//                lists[temp] = lists[temp].next;
//                if (lists[temp] == null)
//                    count++;
//                cur = cur.next;
//
//            }
//        }
//
//        return head.next;
//        /**
//         利用一个按节点值最小次序排列的优先队列, 每次取最小的节点加入返回链表中,
//         并将最小节点的下一个节点再加入队列中, 注意非null判断, 复杂度O(NlogK)
//         **/
//        if(lists.length < 1) return null;
//        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
//        ListNode head = new ListNode(0);
//        ListNode cur = head;
//        for(ListNode p : lists)
//            if(p != null)
//                pq.offer(p);
//        while(!pq.isEmpty()) {
//            cur.next = pq.poll();
//            cur = cur.next;
//            if(cur.next != null)
//                pq.offer(cur.next);
//        }
//        return head.next;
        if(lists.length==0||lists==null){
            return null;
        }
        int n = lists.length;
        while (n > 1) {
            int k = (n + 1) / 2;
            for (int i = 0; i < n / 2; ++i) {
                lists[i] = mergeTwoLists(lists[i], lists[i + k]);
            }
            n = k;
        }
        return lists[0];
    }
   public static  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1!=null && l2!=null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        //若两条链表长度不同，直接接上长链表
        if (l1!=null) cur.next = l1;
        if (l2!=null) cur.next = l2;
        return head.next;
    }
    public static void main(String... args) {
        ListNode l1 = null;


        ListNode l2 = null;


        ListNode l3 = null;


        ListNode[] listNodes = new ListNode[]{l1, l2, l3};
        ListNode newHead = mergeKLists(listNodes);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
