/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-27 23:10
 * @Description:
 */
public class Solution791 {
    public String customSortString(String S, String T) {
        int count[] = new int[26];
        char t[] = T.toCharArray();
        for (char c : t) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            while (count[S.charAt(i)-'a'] > 0) {
                sb.append(S.charAt(i));
                count[S.charAt(i)-'a']--;
            }
        }
        for (int i = 0; i < count.length; i++) {

            while (count[i] > 0) {
                sb.append((char) (i + 'a'));
                count[i]--;
            }
        }
        return sb.toString();
    }
}
