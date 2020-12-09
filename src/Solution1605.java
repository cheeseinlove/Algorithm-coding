/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-03 23:24
 * @Description:
 */
public class Solution1605 {
    public static void main(String[] args) {
        int r[]=new int[]{3,8};
        int c[]=new int[]{4,7};
        restoreMatrix(r,c);
    }
    //i，j涉及的rowSum[i]，colSum[j]优先定格使用小的
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
       int m=rowSum.length;
       int n=colSum.length;
       int ans[][]=new int[m][n];
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if (rowSum[i]==0||colSum[j]==0){
                   continue;
               }else {
                   //优先把小的铺满
                   if (rowSum[i]<=colSum[j]){
                       ans[i][j]=rowSum[i];
                       rowSum[i]-=ans[i][j];
                       colSum[j]-=ans[i][j];
                   }else {
                       ans[i][j]=colSum[j];
                       rowSum[i]-=ans[i][j];
                       colSum[j]-=ans[i][j];
                   }
               }
           }
       }
       return ans;
    }
}
