/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-22 23:26
 * @Description:
 */
public class Solution461 {
    public int hammingDistance(int x, int y) {
     int ans=0;
     //问题转化为异或的结果有几个1
     int v=x^y;
     while (v>0){
         //这个操作将v的从低位到高位的1逐渐置为0
         v=v&(v-1);
         ans++;
     }
     return ans;
    }
}
