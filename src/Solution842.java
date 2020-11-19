import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-29 21:15
 * @Description:
 */
public class Solution842 {
    public static void main(String[] args) {
        String s = "5511816597";
        List<Integer> ans = splitIntoFibonacci(s);
        for (Integer i : ans) {
            System.out.println(i);
        }
    }

    public static List<Integer> splitIntoFibonacci(String S) {

        List<Integer> ans = new ArrayList<>();
        if (S.length() < 3) {
            return ans;
        }
        dfs(S, 0, ans);
        return ans;


    }

    // index当前索引，前两个数直接加
    public static boolean dfs(String s, int index, List<Integer> ans) {
        if (index == s.length()) {
            //只有两段的情况是不成立斐波那契的
            if (ans.size()<3){
                return false;
            }
            return true;
        }
        for (int i = index; i < s.length(); i++) {
            String curS = s.substring(index, i + 1);
            if (curS.startsWith("0") && !curS.equals("0")) {
                continue;
            }
            if(curS.length()>10 || Long.valueOf(curS)>Integer.MAX_VALUE){
                break;
            }
            int cur = Integer.parseInt(curS);
            if (isFibonacciSequence(cur, ans)) {
                ans.add(cur);
                boolean f = dfs(s, i + 1, ans);
                //如果后面组不成斐波那契那就移除,如果后面能组成的话找到一组直接返回true
                if (!f) {
                    ans.remove(ans.size() - 1);
                    //如果当前数大于fi-2+fi-1那么之后的循环没必要遍历了
                    if (ans.size()>=2&&cur>ans.get(ans.size() - 2) + ans.get(ans.size() - 1)){
                       break;
                    }
                }else return true;
            }
        }
        return false;


    }

    private static boolean isFibonacciSequence(Integer num, List<Integer> ans) {
        int size = ans.size();
        if (size < 2) return true;
        return (ans.get(size - 2) + ans.get(size - 1) == num);
    }


}