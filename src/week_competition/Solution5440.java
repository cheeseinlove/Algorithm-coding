package week_competition;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-21 10:51
 * @Description:
 */
public class Solution5440 {
    public static void main(String[] args) {
        System.out.println(xorOperation(5,0));
    }

    public static int xorOperation(int n, int start) {
        int ans = start;
        for (int i = 1; i < n; i++) {
            ans ^= start + 2 * i;
        }
        return ans;
    }
}
