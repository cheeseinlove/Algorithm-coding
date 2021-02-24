import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-30 23:16
 * @Description:
 */
public class Solution395 {
    public static void main(String[] args) {
        int a=longestSubstring("bbaaacbd",3);
    }
    //如果字符在子串中的频率小于k，那么该字符一定不在该子串的longestSubstring中
    public static int longestSubstring(String s, int k) {
        int count[] = new int[26];
        //记录切割点坐标
        List<Integer> split = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                split.add(i);
            }
        }
        if (split.isEmpty()) {
            return s.length();
        }
        int pre = 0;
        int ans = 0;
        for (int i : split) {
            if (i <= pre) {
                pre = i + 1;
                continue;
            }
            ans=Math.max(ans,longestSubstring(s.substring(pre,i),k));
            pre = i + 1;
        }
        if (pre<s.length()){
            ans=Math.max(ans,longestSubstring(s.substring(pre),k));

        }
        return ans;
    }
}
