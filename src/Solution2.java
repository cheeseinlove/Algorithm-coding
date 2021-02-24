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
        temp.next = new ListNode(0);
        result.val = a.get(0);
        for (int i = 0; a.get(i + 1) != null; i++) {
            if (i == 0) {
                result.next = temp.next;
            } else {
                temp.val = a.get(i);
            }
            temp.next = new ListNode(a.get(i + 1));
            temp = temp.next;
        }

        return result;

    }

    public static void main(String... args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        addTwoNumbers2(l1, l4);
        System.out.println(a.toString());
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode ll = l1;
        ListNode rr = l2;
        if (ll == null && rr == null) {
            return null;
        }
        ListNode pre = new ListNode(0);
        ListNode ans = pre;
        int next = 0;
        while (ll != null || rr != null) {
            int v1 = 0;
            int v2 = 0;
            if (ll != null) {
                v1 = ll.val;
                ll=ll.next;
            }
            if (rr != null) {
                v2 = rr.val;
                rr=rr.next;
            }
            ListNode cur = new ListNode((v1 + v2 + next) % 10);
            pre.next = cur;
            pre=cur;
            next = (v1 + v2 + next) / 10;
        }
        if (next!=0){
            pre.next=new ListNode(next);
        }
        return ans.next;
    }
}
