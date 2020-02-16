/**
 * @Author liuxun05
 * @create 2020/2/16 23:59
 **/
public class Solution413 {
    public static void main(String[] args) {
        int A[]=new int[]{1,2,3,4};
        System.out.println(numberOfArithmeticSlices(A));
    }
    public static int numberOfArithmeticSlices(int[] A) {
        //dp[i]表示以当前坐标结尾的等差数列数
        int dp[]=new int[A.length];
        int sum=0;
        for(int i=2;i<A.length;i++){
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                //1表示当前坐标结尾的三个数字的等差和数列，dp[i-1]表示当前坐标和之前状态合起来的等差数列数量
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }
}
