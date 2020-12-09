import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-01 23:10
 * @Description:
 */
public class Solution1497 {
    //a+b的和能被k整除当且当a和b对k取余的和为0或k
    public boolean canArrange(int[] arr, int k) {
        int[] bucket = new int[k];
        Arrays.stream(arr).forEach(value -> {
            int kk = value % k;
            //如果是负数如a=-7,k=5取余为-2那么余数映射为3，即还需要余数为2的数才能整除
            if (kk < 0) {
                kk += k;
            }
            bucket[kk]++;
        });
        //和为0的数为偶数
        if (bucket[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i <= k/2; i++) {
            //取余后和为k的数一样多，如k=5,余2和余3需要一样多
            if (!(bucket[i] == bucket[k - i])) {
                return false;
            }
        }
        return true;
    }
}
