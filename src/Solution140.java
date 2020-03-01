import tools.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-01-22 15:06
 * @Description:
 */
public class Solution140 {
    public static void main(String[] args) {
        String case1 = "catsanddog";
        List<String> list1 = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        String case2 = "pineapplepenapple";
        List<String> list2 = new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
//        System.out.println(wordBreak(case1, list1).size());
//        PrintUtils.printList(wordBreak(case1, list1));
        PrintUtils.printList(wordBreak3(case2, list2));


    }

    public static List<String> wordBreak3(String s, List<String> wordDict) {
        LinkedList<String>[][] dp = new LinkedList[s.length()+1][s.length()+1];
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        dp[s.length() ][s.length() ] = initial;
        for (int i = s.length() - 1; i >= 0; i--) {
            LinkedList<String> list = new LinkedList<>();
            for (int j = s.length(); j > i; j--) {
                if (dp[j][s.length()].size() > 0 && wordDict.contains(s.substring(i, j))) {
                    for (String l : dp[j][s.length()]) {
                        list.add(s.substring(i, j) + (l.equals("") ? "" : " ") + l);
                    }
                }
                dp[i][s.length() - 1] = list;
            }
        }
        return dp[0][s.length() - 1];
    }

    public static List<String> wordBreak2(String s, List<String> wordDict) {
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;
        //双指针j,i,i代表结尾,j代表两个子串的界限
        for (int i = 1; i <= s.length(); i++) {
            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String l : dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }
        return dp[s.length()];
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {


        return wordBreakBackingTrace(s, wordDict, 0);
    }

    public static List<String> wordBreakBackingTrace(String s, List<String> wordDict, int start) {
        List<String> res = new ArrayList<>();
        for (int i = start + 1; i <= s.length(); i++) {
            //如果当前词能查到字典
            if (wordDict.contains(s.substring(start, i))) {
                //最后一个词直接加入数组
                if (i == s.length()) {
                    res.add(s.substring(start, i));
                } else {
                    List<String> combine = combineString(s.substring(start, i), wordBreakBackingTrace(s, wordDict, i));
                    res.addAll(combine);
                }
            }

        }
        return res;
    }

    public static List<String> combineString(String origin, List<String> rest) {
        List<String> res = new ArrayList<>();
        if (res != null && rest.size() > 0) {
            for (String s : rest) {
                res.add(origin + " " + s);
            }
        }
        return res;
    }
}
