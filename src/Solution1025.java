/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-16 23:05
 * @Description:
 */
public class Solution1025 {
    public static void main(String[] args) {
        System.out.println(divisorGame(2));
    }

    public static boolean divisorGame(int N) {
        boolean dp[][] = new boolean[N + 1][2];
        dp[0][0] = false;
        dp[0][1] = true;
        dp[1][0] = false;
        dp[1][1] = true;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    //只要有能赢的就是最优解
                    dp[i][0] = dp[i][0] | dp[i - j][1];
                }
            }
            dp[i][1] = !dp[i][0];
        }
        return dp[N][0];
    }

    public static boolean divisorGame2(int N) {
        //dpi代表N==i时，先手能否赢，后手为取反!dp[i]
        boolean dp[] = new boolean[N + 1];
        dp[0] = false;
        dp[1] = false;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    //只要有能赢的就是最优解
                    dp[i] = dp[i] |(!dp[i - j]);
                }
            }
        }
        return dp[N];
    }
}
