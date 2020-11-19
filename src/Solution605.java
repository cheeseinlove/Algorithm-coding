/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-10 23:13
 * @Description:
 */
public class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int sum = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i - 1 >= 0&&flowerbed[i-1]==1) {
                     continue;
                }
                if (i + 1 < flowerbed.length&&flowerbed[i+1]==1) {
                 continue;
                }
                flowerbed[i]=1;
                sum++;
                if (sum>=n){
                    return true;
                }
            }


        }
        return false;
    }
}
