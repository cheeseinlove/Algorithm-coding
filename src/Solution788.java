import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-28 09:38
 * @Description:
 */
public class Solution788 {
    private Map<Integer, Integer> map;
    public int rotatedDigits(int N) {
        int res = 0;
        map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 5);
        map.put(5, 2);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        for(int i = 1; i <= N; i++){
            if(helper(i))
                res++;
        }
        return res;
    }
    public boolean helper(int num){
        if(num == 0)
            return false;
        Stack<Integer> stack = new Stack<>();
        int a = 0, b = num;
        while(b != 0){
            a = b % 10;
            if(!map.containsKey(a))
                return false;
            stack.push(map.get(a));
            b = b / 10;
        }
        int cmp = 0;
        while(!stack.isEmpty()){
            cmp = cmp * 10 + stack.pop();
        }
        if(cmp == num)
            return false;
        return true;
    }
}
