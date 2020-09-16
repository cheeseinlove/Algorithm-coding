/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-15 22:37
 * @Description:
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length()<s1.length()){
            return false;
        }
    int []ss1=new int[26];
    int []ss2=new int[26];
    for(int i=0;i<s1.length();i++){
        ss1[s1.charAt(i)-'a']++;
        //初始化第一个滑动窗口
        ss2[s2.charAt(i)-'a']++;
    }

    for(int i=0;i<=s2.length()-s1.length();i++){
        if (isSame(ss1,ss2)){
            return true;
        }
        if (i+s1.length()<s2.length()) {
            //固定窗口长度的滑动，右边右移一位，左边右移
            ss2[s2.charAt(i + s1.length()) - 'a']++;
            ss2[s2.charAt(i) - 'a']--;
        }
    }
        return false;
    }
    /**
     * @Description: 判断两个窗口是否相同
     * @param s1
     * @param s2
     * @return boolean
     * @throws
     */
    public boolean isSame(int[]s1,int[]s2){
        for(int i=0;i<s1.length;i++){
            if (s1[i]!=s2[i]){
                return false;
            }
        }
        return true;
    }
}
