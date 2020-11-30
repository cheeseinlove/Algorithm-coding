import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-27 19:36
 * @Description:
 */
public class Solution1414 {
    public static void main(String[] args) {

    }

    public int findMinFibonacciNumbers(int k) {
        int a = 1, b = 1;
        List<Integer> fibo = new ArrayList<Integer>(Arrays.asList(a, b));
        while (a + b <= k) {
            fibo.add(a + b);
            int c = a + b;
            a = b;
            b = c;
        }
        int ans = 0;
        for (int i = fibo.size() - 1; i >= 0; --i) {
            if (k >= fibo.get(i)) {
                ++ans;
                k -= fibo.get(i);
            }
        }
        return ans;


    }
}
