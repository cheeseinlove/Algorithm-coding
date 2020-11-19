/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-17 21:14
 * @Description:
 */
public class Solution738 {
    public int monotoneIncreasingDigits(int N) {
        String s = String.valueOf(N);
        int length = s.length();
        char[] chars = s.toCharArray();
        //flag以后的位置全部置9
        int flag = length;
        for (int i = length - 1; i >= 1; i--) {
            //如果前一位更大，则前一位-1，后续位置全部置9
            if (chars[i] < chars[i - 1]) {
                flag = i;
                chars[i - 1]--;
            }
        }

        for (int i = flag; i < length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }
}
