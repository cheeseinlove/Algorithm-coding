import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CombineSum {
    public static List<List<Integer>> res = new LinkedList<>();

    private static List<List<Integer>> sum1(int[] a, int t) {
        Arrays.sort(a);
        recur1(new LinkedList<Integer>(), 0, 0, a, t);
        return res;
    }

    private static void recur1(LinkedList<Integer> list, int sum, int index, int[] a, int t) {
        //对于for而言只有小于才进入下一层
        LinkedList<Integer> next = new LinkedList<>(list);
        if (sum > t)
            return;
        if (sum == t) {
            res.add(next);

        } else {
            //对于同一层的数而言可以选择添加或不添加但一层必须添加一个数才能进入下一层
            for (int i = index; i < a.length; i++) {
                next.add(a[i]);
                sum += a[i];
                recur1(next, sum, i+1, a, t);
                next.pollLast();
                sum -= a[i];
            }

        }


    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = new int[]{10, 1, 2, 7, 6, 1, 5};

        System.out.print(sum1(a, 8).toString());
    }

}