import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-02 10:26
 * @Description:
 */
public class Solution684 {
    public static void main(String[] args) {

        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int ans[] = findRedundantConnection(edges);
        for (int i : ans) {
            System.out.print(i + ",");
        }
    }

    public static int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU();
        List<Integer> res = new ArrayList<>();
        for (int edge[] : edges) {
            int x = edge[0];
            int y = edge[1];
            if (dsu.isConstant(x, y)) {
                res.add(x);
                res.add(y);
                continue;
            }
            dsu.union(x, y);

        }
        int ans[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    static class DSU {
        int parent[] = new int[1024];

        public  DSU() {
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public boolean isConstant(int x, int y) {
            return find(x) == find(y) ;
        }


        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }

        }

    }

}
