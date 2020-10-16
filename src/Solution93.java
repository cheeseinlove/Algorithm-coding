import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-24 23:33
 * @Description:
 */
public class Solution93 {
    public static void main(String[] args) {
        List<String> ans = restoreIpAddresses("101023");
        for (String s : ans) {
            System.out.println(s);
        }
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 4) {
            return ans;
        }
        dfs(ans, 0, 0, s, new StringBuilder());
        return ans;

    }

    //len-i-1=剩下长度 >=4-num-1
    public static void dfs(List<String> res, int start, int num, String s, StringBuilder sb) {
        if (num == 3) {
            String temp = s.substring(start, s.length());
            if (isValid(temp)) {
                res.add(new StringBuilder(sb).append(temp).toString());
            }
            return;
        }
        int upper = s.length() + num - 4;
        for (int i = start; i <= upper; i++) {
            //当前的子串
            String temp = s.substring(start, i + 1);
            if (isValid(temp)) {
                StringBuilder newSB = new StringBuilder(sb).append(temp).append(".");
                dfs(res, i + 1, num + 1, s, newSB);
            }
        }
    }

    public static boolean isValid(String s) {
        if (s.length() < 2) {
            return true;
        }
        if (s.length()>3){
            return false;
        }
        if (s.charAt(0) == '0') {
            return false;
        }
        if (Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}
