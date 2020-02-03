import tools.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.println(wordBreak(case1, list1).size());
        PrintUtils.printList(wordBreak(case1, list1));
//        PrintUtils.printList(wordBreak(case2, list2));


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
