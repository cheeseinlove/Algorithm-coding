/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-13 12:18
 * @Description:
 */
public class Solution171 {
    public static void main(String[] args) {


        String s = "ZY";
        System.out.println(titleToNumber(s));
    }

    public static int titleToNumber(String s) {
        int values[] = new int[27];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }

        int len = s.length();
        int ans = 0;
        while (len > 0) {
            ans += values[s.charAt(s.length() - len) - 64]*Math.pow(26,len-1);
            len--;
        }
        return ans;
    }
}
