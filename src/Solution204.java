import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-19 20:25
 * @Description:
 */
public class Solution204 {
    public static void main(String[] args) {

        System.out.println(countPrimes(10));
    }
    public static int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        // 将数组都初始化为 true
        Arrays.fill(isPrim, true);

        for (int i = 2; i < n; i++)
            if (isPrim[i])
                // i 的倍数不可能是素数了
                for (int j = 2 * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;


    }
}
