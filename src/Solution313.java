/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-20 23:58
 * @Description:
 */
public class Solution313 {
    public static void main(String[] args) {
        nthSuperUglyNumber(12,new int[]{2,7,13,19});
    }
    //丑数一定来源于丑数相乘，对于从小到大的丑数序列一定是来源之前的丑数相乘
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int ans[] = new int[n];
        ans[0] = 1;
        int next = 1;
        //记录每个原始的质因数该乘ans数组的索引
        int index[] = new int[primes.length];
        while (next < n) {
            int min = Integer.MAX_VALUE;
            int curIndex = 0;
            for (int i = 0; i < primes.length; i++) {
                //如果有重复情况则往后移
                if (ans[index[i]] * primes[i]<=ans[next-1]){
                    index[i]++;
                }
                if (ans[index[i]] * primes[i] < min) {
                    curIndex = i;
                    min = ans[index[i]] * primes[i];
                }
            }
            //当前next最小的丑数往后移一格
            index[curIndex]++;
            ans[next] = min;
            next++;
        }


        return ans[n - 1];
    }
}
