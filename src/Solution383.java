/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-28 22:09
 * @Description:
 */
public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            map[magazine.charAt(i) - 97]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (map[ransomNote.charAt(i) - 97] > 0) {
                map[ransomNote.charAt(i) - 97]--;
            } else {
                return false;
            }
        }
        return true;
    }

}
