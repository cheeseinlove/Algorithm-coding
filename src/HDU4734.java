/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-10 19:21
 * @Description:
 */

import java.util.Arrays;

/**
 * 求f(0)~f(B)中,有几个小于等于 f(A)的;
 * <p>
 * 函数f 就是把一个数字一位位分开,右边开始 第一位*2^0  + 第二位*2^1....第n位*2^(n-1);
 */
public class HDU4734 {
    static int nums[];
    static int valueA;
    static int dp[][];

    public static void main(String[] args) {
        System.out.println(calculate(100, 1000));

    }

    public static int calculate(int a, int b) {
        valueA = f(a);
        nums=new int[10];
        int i = 0;
        while (b > 0) {
            nums[i++] = b % 10;
            b /= 10;
        }
        dp = new int[10][1 << 10];
        for (int j = 0; j < dp.length; j++) {
            Arrays.fill(dp[j], -1);
        }
        return dfs(i - 1, 0, true,"");
    }

    public static int dfs(int pos, int sum, boolean limit,String num) {
        if (pos == -1) {
            return 1;
        }
        //如果当前和比f(a)大，那么一定不满足
        if (sum > valueA) {
            return 0;
        }
        //用减法是为了节约空间复杂度，若当前位置+剩下位置的最大值都比f(a)小，那么一定是满足的且可以记忆化，因为只要不达上界剩下位置都是随便选，如f(a)=14,b=1000,Fmax（010x）和Fmax（002x）都是4+9=13<14
        if (!limit && dp[pos][valueA - sum] != -1) {
            return dp[pos][valueA - sum];
        }
        int up = limit ? nums[pos] : 9;
        int ans = 0;
        for (int i = 0; i <= up; i++) {
            ans += dfs(pos - 1, sum + i * (1 << pos), limit && i == nums[pos],num+i);
        }
        if (!limit) {
            dp[pos][valueA - sum] = ans;
        }
        return ans;
    }

    /**
     * 计算f(x)
     *
     * @param x
     * @return
     */
    public static int f(int x) {
        if (x == 0) {
            return 0;
        }

        int ans = f(x / 10);
        return ans * 2 + (2 % 10);
    }
}
