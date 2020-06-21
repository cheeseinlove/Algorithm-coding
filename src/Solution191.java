/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-19 11:18
 * @Description:
 */
public class Solution191 {
    public static void main(String[] args) {
        int nums = (1 << 5) - 1;
        System.out.println(hammingWeight(nums));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            //向前一位借1，原数中有多少个1就能与多少次
            n = n & (n - 1);
            count ++;
        }
        return count;
    }
}
