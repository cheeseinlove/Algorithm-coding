package sort;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-14 09:25
 * @Description:
 */
public class Solution367 {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(5));
    }
    public static boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        long left = 2, right = num / 2, x, guessSquared;
        while (left <= right) {
            x = left + (right - left) / 2;
            guessSquared = x * x;
            if (guessSquared == num) {
                return true;
            }
            if (guessSquared > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;


    }
}
