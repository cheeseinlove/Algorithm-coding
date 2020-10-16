/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-30 17:22
 * @Description:
 */
//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
//
//示例 1:
//
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
//示例 2:
//
//输入: "aba"
//
//输出: False
//
public class Solution459 {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("aaa"));
    }
    //一个大串能由相同小串组成，实际上就是找循环节
    public static boolean repeatedSubstringPattern(String s) {
        boolean flag = false;
        //不能自己组成自己
        for (int i = 0; i < s.length() - 1; i++) {
            //循环长度
            int len = i - 0 + 1;
            //首先长度满足整数倍
            if (s.length() % len != 0) {
                continue;
            }
            flag = true;
            int j = 0 + len;
            while (j < s.length()) {
                for (int k = 0; k <= i; k++) {
                    if (s.charAt(k) != s.charAt(j + k)) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
                j += len;
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    //设s=m+m , a= s+s = m+m+m+m ，断其首尾字符，a=(1+x)+m+m+(y+1)，中间必定有m+m, m+m=s。 s由多个m的情况同理。
    public  boolean repeatedSubstringPattern2(String s) {
        if(s.length()==0)return false;
        String plus=s+s;
        return plus.substring(1,plus.length()-1).contains(s);
    }


}
