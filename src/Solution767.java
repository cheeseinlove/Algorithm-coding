import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-26 23:43
 * @Description:
 */
public class Solution767 {
    public String reorganizeString(String S) {
        int n = S.length();
        char str[] = S.toCharArray();
        int count[] = new int[26];
        for (char c : str) {
            count[c - 'a'] += 100;
        }
        for (int i = 0; i < count.length; i++) {
            count[i] += i;
            if (count[i] / 100 > (n + 1) / 2) {
                return "";
            }
        }
        Arrays.sort(count);
        char ans[] = new char[n];
        int index = 1;
        for (int c : count) {
            int cnt = c / 100;
            char ch = (char) (c % 100 + 'a');
            //间隔字母排列的骚操作，前提是每个字母出现次数不能超过(n+1)/2
            for (int i = 0; i < cnt; i++) {
                if (index >= n) {
                    index = 0;
                }
                ans[index] = ch;
                index += 2;
            }
        }


        return String.valueOf(ans);


    }
}
