/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-03 23:26
 * @Description:
 */
public class Solution718 {
    public static void main(String[] args) {
        int a[] = new int[]{0,1,1,1,1};
        int b[] = new int[]{1,0,1,0,1};

        System.out.println(findLength(a, b));
    }

    public static int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) {
            return 0;
        }
        //i,j代表A[i]和B[j]结尾的相同数组长度
        int dp[][] = new int[A.length][B.length];
        int max = dp[0][0];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (i == 0 && 0 == j) {
                    dp[0][0] = A[0] == B[0] ? 1 : 0;
                } else if (A[i] == B[j]) {
                    if (i == 0) {
                        dp[i][j] =  1;
                    } else if (j == 0) {
                        dp[i][j] =  1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
