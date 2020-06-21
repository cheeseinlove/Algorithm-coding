/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-17 09:09
 * @Description:
 */
public class Solution172 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;


    }
}
