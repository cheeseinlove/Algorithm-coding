package week_competition;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-06 21:07
 * @Description:
 */
public class Solution5620 {
    int mod = 1000_000_000 + 7;

    public int concatenatedBinary(int n) {
        long res = 1;
        for(int i = 2; i <= n; i++) {
            res = ((res << Integer.toBinaryString(i).length()) + i) % mod;
        }
        return (int)res;
    }


}
