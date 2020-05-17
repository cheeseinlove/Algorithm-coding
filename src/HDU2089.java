/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-10 09:03
 * @Description:
 */

import java.util.Arrays;

/**
 * 给定范围0，N,输出0,N有多少个数满足数位上不能有4和连续62
 */
public class HDU2089 {
    static int num[];
    static int dp[][];

    public static void main(String[] args) {
        System.out.println(numDistinguishedAtMostN(10));
    }

    /**
     * 原题是求区间，只用numDistinguishedAtMostN(b)-numDistinguishedAtMostN(a-1)就是区间值
     * @param N
     * @return
     */
    public static int numDistinguishedAtMostN(int N) {
        int i = N;
        int N2 = N;
        int j = 0;
        while (i > 0) {
            i /= 10;
            j++;
        }
        num = new int[j];
        int m = j;
        while (N2 > 0) {
            num[--m] = N2 % 10;
            N2 /= 10;
        }
        //前j位最后一位是否为6的情况数
        dp = new int[j][2];
        for (int a = 0; a < dp.length; a++) {
            Arrays.fill(dp[a], -1);
        }
        return dfs(0, 1, 1, 0) ;
    }

    public static int dfs(int index, int isUp, int isZero, int isSix) {
        if (index == dp.length) {
            return 1;
        }
        if (isUp != 1 && isZero != 1 && dp[index][isSix] != -1) {
            return dp[index][isSix];
        }
        int up = isUp == 1 ? num[index] : 9;
        int ans = 0;
        for (int i = 0; i <= up; i++) {
            //不能有4
            if (i == 4) {
                continue;
            }
            //不能连续62
            if (isSix == 1 && i == 2) {
                continue;
            }
            int isUp2 = (isUp == 1 && i == num[index]) ? 1 : 0;
            int isZero2 = (isZero == 1 && i == 0) ? 1 : 0;
            int isSix2 = i == 6 ? 1 : 0;
            ans += dfs(index + 1, isUp2, isZero2, isSix2);
        }
        if (isUp != 1 && isZero != 1 && dp[index][isSix] != -1) {
            dp[index][isSix] = ans;
        }
        return ans;
    }
}