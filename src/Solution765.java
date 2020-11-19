/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-16 22:24
 * @Description:
 */
public class Solution765 {
    public static void main(String[] args) {
        int r[]=new int[]{0,2,3,6,4,1,7,5};
        System.out.println(minSwapsCouples2(r));
    }
    //奇数异或值-1，偶数异或值+1，通过异或找到配对的值
    public int minSwapsCouples(int[] row) {
        int ans = 0;
        for (int i = 0; i < row.length; i += 2) {
            int cur = row[i];
            if (row[i + 1] == (cur ^ 1)) {
                continue;
            }
            ans++;
            for (int j = i + 2; j < row.length; j++) {
                if (row[j] == (cur ^ 1)) {
                    row[j] = row[i + 1];
                    row[i + 1] = (cur ^ 1);
                    break;
                }
            }
        }
        return ans;
    }
    private static class UnionFind{
        public  int[] parent;
        public   int[] weight;
        UnionFind(int[] row){
            int m = row.length / 2;
            parent = new int[m];
            weight = new int[m];
            for(int i = 0; i < m; i++){
                parent[i] = i;
                weight[i] = 1;
            }
        }
        public int find(int x){
            if(parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx == rooty) return;
            if(weight[rootx] > weight[rooty]){
                parent[rooty] = rootx;
                weight[rootx] += weight[rooty];
            }else{
                parent[rootx] = rooty;
                weight[rooty] += weight[rootx];
            }
        }

        public  int getRet(){
            int ret = 0;
            for(int i = 0; i < parent.length; i++){
                if(parent[i] != i) ret++;
            }
            return ret;
        }
    }

    public static int minSwapsCouples2(int[] row) {
        UnionFind uf = new UnionFind(row);
        for(int i = 0; i < row.length; i += 2){
            uf.union(row[i] / 2, row[i + 1] / 2);
        }
        int p[]=uf.parent;
        return uf.getRet();
    }


}
