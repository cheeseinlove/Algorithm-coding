import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-02-01 23:40
 * @Description:
 */
public class Solution1743 {
    public static void main(String[] args) {
        restoreArray(new int[][]{{2,1},{3,4},{3,2}});
    }
    public static int[] restoreArray(int[][] adjacentPairs) {
        //存邻接节点
        Map<Integer, List<Integer>> map = new HashMap<>();
        int head = 0;
        for (int i = 0; i < adjacentPairs.length; i++) {
            int u = adjacentPairs[i][0];
            int v = adjacentPairs[i][1];
            List<Integer> ls = map.getOrDefault(u, new ArrayList<>());
            ls.add(v);
            List<Integer> ls2 = map.getOrDefault(v, new ArrayList<>());
            ls2.add(u);
            map.put(u, ls);
            map.put(v, ls2);
        }
        //出度为2的当做头结点，有两个这里找到一个就行了
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                head = entry.getKey();
                break;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        int[] res = new int[map.size()];
        res[0] = head;
        set.add(head);
        int i = 1;
        while (i < res.length) {
            List<Integer> ls = map.get(res[i - 1]);
            for (int j = 0; j < ls.size(); j++) {
                if (!set.contains(ls.get(j))) {
                    res[i++] = ls.get(j);
                    set.add(ls.get(j));
                    break;
                }
            }
        }
        return res;
    }
}
