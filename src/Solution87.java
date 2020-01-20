/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-01-20 11:11
 * @Description:
 */
public class Solution87 {
    public static void main(String[] args) {
        String tar1 = "great";
        String case1 = "rgeat";
        String tar2 = "abcde";
        String case2 = "caebd";
        System.out.println(isScramble(tar1, case1));
        System.out.println(isScramble(tar2, case2));
    }

    /**
     * 若s1,s2是扰乱的一定有个数i将s1,s2分为两部分，s11,s12,s21,s22其中要么s11和s21是扰乱且s12和s22是扰乱(case A)，要么s11和s22(新的s22要做一次substring)是扰乱且s12和s21是扰乱的(case B)。
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (!isEqual(s1, s2)) {
            return false;
        }

        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            //这里case B又做了一次substring是因为i代表截取长度
            if (isScramble(s11,s21)&&isScramble(s12,s22)||isScramble(s11,s2.substring(s1.length()-i))&&isScramble(s12,s2.substring(0,s1.length()-i))) {
                return true;
            }
        }


        return false;
    }

    //全是小写
    public static boolean isEqual(String s1, String s2) {
        int counts[] = new int[26];
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
