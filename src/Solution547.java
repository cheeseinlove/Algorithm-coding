/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-05-25 22:00
 * @Description:
 */
public class Solution547 {

    public int findCircleNum(int[][] M) {
        int k = M.length;
        DSU dsu=new DSU(k);
        for (int i = 0; i < M.length; i++) {
            for (int j = i; j <= M[i].length; j++) {
                if (M[i][j] == 1) {
                  dsu.union(i,j);
                }
            }
        }
        return dsu.getSize();
    }

    class DSU {
        int parent[];
        int size;

        public DSU(int length) {
            size=length;
            parent = new int[length];
            for(int i=0;i<length;i++){
                parent[i]=i;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                size--;
            }
        }

        public int getSize() {
            return size;
        }
    }
}
