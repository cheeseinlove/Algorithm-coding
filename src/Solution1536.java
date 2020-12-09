/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-02 20:25
 * @Description:
 */
public class Solution1536 {
    //交换行只能上下交换，通过定义f{i}来表示当前行满不满足条件
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] f = new int[n];
        // 记录每一行里面从右边开始数第一个1的位置
        // 要满足对角线以上的格子全部都是 0，必须满足:f[i] <= i
        for(int i = 0; i < n; i++){
            for(int j = n-1; j >= 0; j--){
                if(grid[i][j] == 1){
                    f[i] = j;
                    break;
                }
            }
        }
        int ans = 0;
        int pos = 0;
        for(int i = 0; i < n; i++){
            if(f[i] <= i){
                continue;//这行已经符合条件了
            }
            //往下遍历后面的行，找到[最先]满足条件的，一行行换上去
            int j;
            for(j = i + 1; j < n; j++){
                if(f[j] <= i){
                    pos = j;//pos为最先满足条件的行数
                    break;
                }
            }
            if(j == n) return -1;//找不到满足条件的行
            //交换 并计算交换次数
            for(int k = pos; k > i; k--){
                //交换f[k-1]和f[k]
                int tmp = f[k-1];
                f[k-1] = f[k];
                f[k] = tmp;
            }
            ans += (pos - i);
        }
        return ans;


    }
}
