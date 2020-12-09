import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-01 19:29
 * @Description:
 */
public class Solution1433 {
    public boolean checkIfCanBreak(String s1, String s2) {
        if (s1.length() != s2.length() || s1.length() == 0) {
            return false;
        }
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        Arrays.sort(ss1);
        Arrays.sort(ss2);

        return IsContent(ss1,ss2)||IsContent(ss2,ss1);
    }
    private boolean IsContent(char[] chars1, char[] chars2) {
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i]>chars2[i]) return false;
        }
        return true;
    }
}
