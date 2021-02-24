/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-25 20:58
 * @Description:
 */
public class Solution242 {
    public static void main(String[] args) {

    }

    //移位词
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int sNum[] = new int[26];
        int tNum[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sNum[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            tNum[t.charAt(i) - 'a']++;
        }
        for(int i=0;i<sNum.length;i++){
            if (sNum[i]!=tNum[i]){
                return false;
            }
        }
        return true;
    }
}
