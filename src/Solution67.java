/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-23 22:53
 * @Description:
 */
public class Solution67 {
    public static void main(String[] args) {
        System.out.println(addBinary("1010","1011"));
    }
    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder("");
        int len1 = a.length();
        int len2 = b.length();
        int cur = 0;
        int next = 0;
        int index = 1;
        while (index <= Math.max(len1, len2)) {
            cur = next;
            if (len1 - index >= 0) {
                cur += Integer.parseInt(String.valueOf(a.charAt(len1 - index)));
            }
            if (len2 - index >= 0) {
                cur += Integer.parseInt(String.valueOf(b.charAt(len2 - index)));
            }
            next = cur / 2;
            cur = cur % 2;
            ans.insert(0, cur);
            index++;
        }
        if (next != 0) {
            ans.insert(0, next);
        }
        return ans.toString();
    }
}
