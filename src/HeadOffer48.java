import java.util.HashSet;
import java.util.Set;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-18 09:27
 * @Description:
 */
public class HeadOffer48 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int right = 0;
        int left = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right++);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            res = Math.max(res, right - left);
        }
        return res;
    }
}

