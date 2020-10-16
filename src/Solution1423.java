/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-17 09:30
 * @Description:
 */
public class Solution1423 {
    //数组总和固定，求两端拿k个最大，相当于求len-k的窗口和最小
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        for(int i:cardPoints){
            sum+=i;
        }
        int min=Integer.MAX_VALUE;
        int curValue=0;
        int len=cardPoints.length-k;
        if (len<=0){
            return sum;
        }
        for(int i=0;i<cardPoints.length;i++){
            curValue+=cardPoints[i];
            //此时长度为len+1
            if (i>=len){
                curValue-=cardPoints[i-len];
            }
            if (i>=len-1){
                min=Math.min(min,curValue);
            }
        }
        return sum-min;
    }
}
