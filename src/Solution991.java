/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-20 20:28
 * @Description:
 */
public class Solution991 {
    public static void main(String[] args) {

    }
     //尽量使用乘法
    public int brokenCalc(int X, int Y) {
        int ans = 0;
        while (Y > X) {
            ans++;
            if (Y % 2 == 0) {
                Y /= 2;
            } else {
                Y += 1;
            }
        }
        ans += X - Y;
        return ans;
    }
}
