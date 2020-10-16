/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-15 09:39
 * @Description:
 */
public class Solution657 {
    public boolean judgeCircle(String moves) {
        int[] cnt = new int[26];
        for(char c : moves.toCharArray()) cnt[c-'A']++;
        return cnt['L'-'A']==cnt['R'-'A'] && cnt['U'-'A']==cnt['D'-'A'];
    }
}
