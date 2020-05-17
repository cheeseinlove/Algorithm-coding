import java.util.TreeMap;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-31 23:38
 * @Description:
 */
public class Solution975 {
    public static void main(String[] args) {
        int A[]=new int[]{1,2,3,2,1,4,4,5};
//        System.out.println(findIndex(A,0,0));
        System.out.println(oddEvenJumps(A));
    }
    public static int oddEvenJumps(int[] A) {
        if (A.length==0){
            return 0;
        }
    boolean dp[][]=new boolean[A.length][2];
        dp[A.length-1][0]=true;
        dp[A.length-1][1]=true;
        TreeMap<Integer,Integer> treeMap=new TreeMap<>();
        treeMap.put(A[A.length-1],A.length-1);
        for(int i=A.length-2;i>=0;i--){
            int index1=findIndex(A,i,0,treeMap);
            int index2=findIndex(A,i,1,treeMap);
        dp[i][0]=index1==-1?false:dp[index1][1];
        dp[i][1]=index2==-1?false:dp[index2][0];
        treeMap.put(A[i],i);
    }

     int ans=0;
     for(int i=0;i<A.length;i++){
         if (dp[i][0]){
             ans++;
         }
     }
     return ans;
    }

    /**
     * 找到数组中比cur稍大/小的索引
     * @param A
     * @param cur
     * @param type
     * @return
     */
    public static int findIndex(int A[],int cur,int type,TreeMap<Integer,Integer> map){
        if (type==0) {
            Integer key=map.ceilingKey(A[cur]);
            return key==null?-1:map.get(key);
        }
        else if (type==1) {
            Integer key=map.floorKey(A[cur]);
            return key==null?-1:map.get(key);
        }
        return -1;
    }

}
