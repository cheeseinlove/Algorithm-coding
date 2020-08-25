import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-18 23:41
 * @Description:
 */
public class Solution475 {
    public int findRadius(int[] houses, int[] heaters) {
        // 先排序，踩坑了，以为是顺序的。
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res= 0;
        int right = 0;
        for(int i = 0; i < houses.length; i++){
            // 找到恰好比当前房屋大的加热器
            while(right+1<heaters.length&&heaters[right]<houses[i]){
                right++;
            }
            // 特判， 否则会出现越界
            if(right==0){
                res = Math.max(res,Math.abs(heaters[right] - houses[i]));
            }else{
                res = Math.max(res,Math.min(Math.abs(heaters[right] - houses[i]),Math.abs(houses[i] - heaters[right-1])));
            }
        }
        return res;
    }


}
