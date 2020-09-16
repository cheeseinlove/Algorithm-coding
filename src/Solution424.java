/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-14 23:29
 * @Description:
 */
public class Solution424 {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB",2));
    }

    public static int characterReplacement(String s, int k) {
        if (s.length()<2){
            return s.length();
        }
        int ans = 1;
        char[] str = s.toCharArray();
        int[] sequence = new int[26];
        int left = 0;
        int right = 0;
        sequence[str[0] - 65] = 1;

        while (right < s.length() && left < s.length()) {
            int len = right - left + 1;
            //若k小于当前总字符数-出现最多的字符次数，则说明k不够了，滑动窗口左滑，反之右划
            if (k < len -getMax(sequence)){
                sequence[str[left] - 65]--;
                left++;
            }else {
                right++;
                ans=Math.max(ans,len);
                if (right < s.length())
                sequence[str[right] - 65]++;
            }
        }


        return ans;
    }

    //当前窗口内频率最多的字符次数
    public static int getMax(int[] sequence) {
        int ans = 0;
        for (int i = 0; i < sequence.length; i++) {
            ans = Math.max(ans, sequence[i]);
        }
        return ans;
    }
}
