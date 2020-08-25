/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-18 23:21
 * @Description:
 */
public class Solution441 {
    public int arrangeCoins(int n) {
        if (n==1){
            return 1;
        }
      int left=1;
      int right=n;
      while (left<right){
          long mid=left+((right-left)>>1);
          long sum=(1+mid)*mid/2;
          if (sum==n){
              return (int) mid;
          }else if (sum<n){
              left=(int) mid+1;
          }else {
              right=(int) mid;
          }
      }
      return left-1;
    }
}
