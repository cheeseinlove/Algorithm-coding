import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-23 17:35
 * @Description:
 */
public class Solution709 {
    public String toLowerCase(String str) {
        StringBuilder sb=new StringBuilder();

        char c[]=str.toCharArray();
        for(char c1:c){
            sb.append((char)(c1|32));
        }
        return sb.toString();

    }
}
