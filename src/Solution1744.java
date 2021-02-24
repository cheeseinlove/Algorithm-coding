/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-02-02 23:32
 * @Description:
 */
public class Solution1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
    boolean[]ans=new boolean[queries.length];
    //吃到第i型糖果至少前面要吃sum[i]个糖果
    long sum[]=new long[candiesCount.length];
     for(int i=1;i<candiesCount.length;i++){
         sum[i]=sum[i-1]+candiesCount[i-1];
     }

     //当天能吃到糖果的话day-1天最少吃sum[type]-(max-1)且天数不能太长如果太长保持最低消费都会吃完了;
     for(int i=0;i<queries.length;i++){
         //要吃糖果类型
         int type=queries[i][0];
         //多少天要吃到
         long day=queries[i][1];
         //每天最多吃多少
         long max=queries[i][2];
         long maxTotal=day*max;
         if (maxTotal>=sum[type]-(max-1)&&day<sum[type+1]){
             ans[i]=true;
         }
     }
    return ans;
    }
}
