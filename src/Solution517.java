/**
 * @Author liuxun05
 * @create 2020/2/23 21:45
 **/
public class Solution517 {
    public int findMinMoves(int[] machines) {
        int length = machines.length;
        int sum = 0;
        for (int value : machines) {
            sum += value;
        }
        int avg = 0;
        if (sum % length != 0) {
            return -1;
        }
        avg = sum / length;
        int left = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            //左侧实际数-期望数
            int sumL = left - avg * i;
            //右侧实际数-期望数
            int sumR = (sum - left - machines[i]) - avg * (length - i - 1);
            //两者大于0说明当前位置i需要向两边分发
            if (sumL <0 && sumR <0) {
                res = Math.max(res, Math.abs(sumL + sumR));
            }
            ///其它情况的瓶颈都在于两者的绝对值的最大值
            else {
                res = Math.max(res, Math.max(Math.abs(sumL), Math.abs(sumR)));
            }


            left += machines[i];
        }
        return res;
    }
}
