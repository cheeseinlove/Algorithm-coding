import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-07 23:52
 * @Description:
 */
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;

    }
}
