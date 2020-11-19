/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-16 08:42
 * @Description:
 */
public class Solution1217 {
    //题目翻译下就是，距离这个位置奇数距离的代价为1，偶数位置代价为0，那只需要统计在奇数位置上的个数就好了
    //若最终转换的地址是偶数，那结果=奇数的个数，若最终转换的地址是奇数。那结果=偶数个数
    public int minCostToMoveChips(int[] position) {
     int old=0;
     int even=0;
     for(int i:position){
         if (i%2==0){
             even++;
         }else {
             old++;
         }
     }

     return Math.min(old,even);
    }
}
