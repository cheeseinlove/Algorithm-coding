/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-05-21 22:25
 * @Description:
 */
public class Solution128 {
    public static void main(String[] args) {
        int nums[] = new int[]{0,-1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length<2){
            return  nums.length;
        }
        int max = Integer.MIN_VALUE;
        UF uf=new UF();
        for (int i = 0; i < nums.length; i++) {
            nums[i]+=1000;
            uf.add(nums[i]);
        }
        for (int i :nums) {
//            if (uf.parent[i-1]!=0){
//                uf.union(i-1,i);
//            }
            if (uf.parent[i]==i&&uf.parent[i+1]!=0){
                uf.union(i,i+1);
            }
        }
        for (int i :nums) {
            max=Math.max(uf.getSize(i),max);
        }
        return max;
    }
}

class UF {
    int parent[]=new int[10000];
    int size[]=new int[10000];

//    public UF(int length) {
//        parent = new int[length];
//        for (int i = 0; i < length; i++) {
//            parent[i] = i;
//            size[i] = 1;
//        }
//    }

    public void add(int x) {
        parent[x] = x;
        size[x] = 1;
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        if (x != y) {
            int oldList=find(x);
            parent[oldList] = find(y);
            //领导者维护size
            size[find(y)]=size[find(y)]+size[oldList];
        }
    }
    public int getSize(int x){
        //返回领导者的size
        return size[find(x)];
    }
}
