import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-11 23:05
 * @Description:
 */
public class Solution1722 {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int ans = 0, n = source.length;
        UnionFind unionFind = new UnionFind(n);
        for (int[] swap : allowedSwaps) {
            unionFind.union(swap[0], swap[1]);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(target[i],k -> new LinkedList<>()).add(i);
        }
//结果总和为两集合中不存在的+换不掉的
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(source[i])) {
                ans++;
                continue;
            }
//target中下标集合
            List<Integer> list = map.get(source[i]);
            Iterator<Integer> iterator = list.iterator();
            boolean flag = false;
            while (iterator.hasNext()) {
                Integer index = iterator.next();
                if (unionFind.connected(i, index)) {
                    iterator.remove();
                    flag = true;
                    break;
                }
            }
            if (!flag)
                ans++;
        }
        return ans;
    }

    private static class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            rank = new int[n];
        }

        // 路径压缩
        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }

            return parent[x] = find(parent[x]);
        }

        // 按秩合并
        public void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);

            if (fx == fy) {
                return;
            }

            if (rank[fx] > rank[fy]) {
                parent[fy] = fx;
            } else {
                parent[fx] = fy;
            }

            if (rank[fx] == rank[fy]) {
                rank[fy]++;
            }
            count--;
        }

        public int count() {
            return count;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

}
