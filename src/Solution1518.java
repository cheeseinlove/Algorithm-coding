/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-30 23:24
 * @Description:
 */
public class Solution1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        return calculate(numBottles, 0, numExchange);
    }

    //喝了full瓶，并去换酒
    public int calculate(int full, int empty, int k) {
        if (full==0&&empty<k){
            return 0;
        }
        int nextFull=(full+empty)/k;
        int nextEmpty=(full+empty)%k;
        return full+calculate(nextFull,nextEmpty,k);
    }
}
