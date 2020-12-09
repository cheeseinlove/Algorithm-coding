package week_competition;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-06 20:44
 * @Description:
 */
public class Solution5617 {
    //源字符只有三种 G ，（），（al）
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append("G");
            } else if (command.startsWith("()", i)) {
                sb.append("o");
                i++;
            } else {
                sb.append("al");
                i += 3;
            }
        }
        return sb.toString();
    }
}
