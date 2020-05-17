import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-26 22:34
 * @Description:
 */
public class Solution956 {
    public static void main(String[] args) {
        System.out.println(tallestBillboard(new int[]{1}));
    }

    public static int tallestBillboard(int[] rods) {
        int n = rods.length;
        if (n < 2) {
            return 0;
        }
        int hash = 100000;

        Map<Integer, Integer> dp = new HashMap<>();

        dp.put(0 * hash + 0, 0);
        dp.put(1 * hash + 0, 0);
        dp.put(1 * hash + rods[0], 0);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1 * hash + 0);
        queue.offer(1 * hash + rods[0]);
        for (int i = 2; i <= n; i++) {
            int h = rods[i - 1];
            for (int j = queue.size(); j > 0; j--) {
                int index = queue.poll();
                int diff = index - (i - 1) * hash;
                int last = dp.get(index);
                //三种情况都要考虑覆盖值的情况
                //不放
                if (dp.containsKey(i * hash + diff)) {
                    dp.put(i * hash + diff, Math.max(dp.get(i * hash + diff), last));
                } else {
                    dp.put(i * hash + diff, last);
                    queue.offer(i * hash + diff);
                }
                //放高的
                if (dp.containsKey(i * hash + diff + h)) {
                    dp.put(i * hash + diff + h, Math.max(dp.get(i * hash + diff + h), last));
                } else {
                    dp.put(i * hash + diff + h, last);
                    queue.offer(i * hash + diff + h);
                }
                //放矮的
                if (diff > h) {
                    if (dp.containsKey(i * hash + diff - h)) {
                        dp.put(i * hash + diff - h, Math.max(dp.get(i * hash + diff - h), last + h));
                    } else {
                        dp.put(i * hash + diff - h, last + h);
                        queue.offer(i * hash + diff - h);
                    }
                } else {
                    if (dp.containsKey(i * hash + h - diff)) {
                        dp.put(i * hash + h - diff, Math.max(dp.get(i * hash + h - diff), last + diff));
                    } else {
                        dp.put(i * hash + h - diff, last + diff);
                        queue.offer(i * hash + h - diff);
                    }
                }
            }
        }
        return dp.containsKey(n * hash + 0) ? dp.get(n * hash + 0) : 0;


    }
}
