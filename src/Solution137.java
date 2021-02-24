/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-05 22:57
 * @Description:
 */
public class Solution137 {
    //如果其他数都出现 3 次，只有目标数出现 1 次，那么每一位的 1 的个数无非有这2种情况，为 3 的倍数（全为出现三次的数） 或 3 的倍数 +1（包含出现一次的数）。
    //这个 3 的倍数 +1 的情况也就是我们的目标数的那一位
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                //先将数右移，并求出最后一位为 1 的个数
                if ((nums[j] >> i & 1) == 1) {
                    count++;
                }
            }
            //找到某一位取余为 1 的数，并左移，为了将这一位循环结束后移至原位
            if (count % 3 != 0) {
                res = res | 1 << i;
            }
        }
        return res;
    }


}
