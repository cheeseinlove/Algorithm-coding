/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-02-01 23:24
 * @Description:
 */
public class Solution326 {
    public boolean isPowerOfThree(int n) {
        if (n==1){
            return true;
        }
       if (n<3){
           return false;
       }

       return (n%3==0)&&(isPowerOfThree(n/3));
    }
}
