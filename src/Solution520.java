/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-09 22:43
 * @Description:
 */
//全部字母都是大写，比如"USA"。
//单词中所有字母都不是大写，比如"leetcode"。
//如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
public class Solution520 {
    public boolean detectCapitalUse(String word) {
        char[] words = word.toCharArray();
        boolean isBeginDetect = false;
        boolean isUpper = false;
        if (words[0] < 97) {
            isBeginDetect = true;
        }
        if (words.length > 1 && words[1] < 97) {
            isUpper = true;
        }
        for (int i = 1; i < words.length; i++) {
            if (!isBeginDetect) {
                if (words[i] < 97) {
                    return false;
                }
            }
            //若非大写开头则后续字符需要保持一致
            if (isBeginDetect && i > 1) {
                if (isUpper && words[i] > 96) {
                    return false;
                }
                if (!isUpper && words[i] < 97) {
                    return false;
                }
            }
        }
        return true;
    }
}
