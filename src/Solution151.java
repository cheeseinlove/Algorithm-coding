import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-25 09:29
 * @Description:
 */
public class Solution151 {
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<String>();
        //作为每个单词的缓冲
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                //重置
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        //最后一个没有空格需要再添加一次
        d.offerFirst(word.toString());

        return String.join(" ", d);


    }
}
