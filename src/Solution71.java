import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-24 09:27
 * @Description:
 */
public class Solution71 {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String item : path.split("/")) {
            //遇到..向上返回一级弹出栈
            if (item.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
                //如果是字母进栈
            } else if (!item.isEmpty() && !item.equals(".")) stack.push(item);
        }
        String res = "";
        for (String d : stack) res = "/" + d + res;
        return res.isEmpty() ? "/" : res;
    }
}
