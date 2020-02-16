/**
 * @Author liuxun05
 * @create 2020/2/16 20:54
 **/
//给定字符串 s 和 t ，判断 s 是否为 t 的子序列，不一定是连续子序列。
public class Solution392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","abagdc"));
    }
    public static boolean isSubsequence(String s, String t) {
     if (t.length()<s.length()){
            return false;
        }
        int index = -1;
        for (char c : s.toCharArray()){
            index = t.indexOf(c, index+1);
            if (index == -1) return false;
        }
        return true;
    }
}
