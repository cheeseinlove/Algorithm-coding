/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-19 09:27
 * @Description:
 */
public class SLution190 {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                res = (res << 1) + (n & 1);
                n >>= 1;
            }
            return res;
        }
    public int reverseBits2(int n) {
        int res = 0;
        for (int i = 0; i <= 31; i++) {
            res ^= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
        }
        return res;
    }




}
