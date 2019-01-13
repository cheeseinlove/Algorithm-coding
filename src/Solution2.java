import tools.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    static ListNode result = new ListNode(0);
    static ArrayList<Integer> a = new ArrayList<Integer>();

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverse = new ListNode(0);
        for (int i = 0; ; i++) {
            reverse.next = new ListNode(0);
            if (l1.val + l2.val >= 10) {
                reverse.val += 1;
                reverse.next.val = l1.val + l2.val - 10;
            } else {
                reverse.next.val = l1.val + l2.val;
            }
            a.set(i, reverse.val);
            a.set(i + 1, reverse.next.val);
            if (!(l1.next == null && l2.next == null)) {
                if (l1.next == null)
                    l1.next = new ListNode(0);
                if (l2.next == null)
                    l2.next = new ListNode(0);
                reverse = reverse.next;
                l1 = l1.next;
                l2 = l2.next;


            } else {
                break;

            }

        }
        if (a.get(0) == 0)
            a.remove(0);
        Collections.reverse(a);
        while (a.contains(10)) {
            int more = a.indexOf(10);
            if (a.get(more + 1) == null)
                a.set(more + 1, 1);
            else
                a.set(more + 1, a.get(more + 1) + 1);

            a.set(more, 0);
        }
        ListNode temp = new ListNode(0);
        temp.next=new ListNode(0);
        result.val=a.get(0);
        for(int i=0;a.get(i+1)!=null;i++){
            if(i==0){
                result.next=temp.next;
            }
            else {
                temp.val=a.get(i);
            }
            temp.next=new ListNode(a.get(i+1));
            temp=temp.next;
        }

        return result;

    }

    public static void main(String... args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);
        l1.val = 2;
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(6);
        l1.next.next.next = new ListNode(4);
        l2.val = 1;
        l2.next = new ListNode(8);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(4);
        addTwoNumbers(l1, l2);
        System.out.println(a.toString());
    }}
//
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}