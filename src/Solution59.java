/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-06 23:21
 * @Description:
 */
public class Solution59 {
    public static void main(String[] args) {
        generateMatrix(3);
    }
    public static int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        int x=0;
        int y=0;
        for(int i=1;i<=n*n;i++){
            ans[x][y]=i;
            //如果能走右边
            if (y+1<n&&ans[x][y+1]==0){
                y+=1;
                continue;
            }
            //如果能走下边
            if (x+1<n&&ans[x+1][y]==0){
                x+=1;
                continue;
            }
            //如果能走左边
            if (y-1>=0&&ans[x][y-1]==0){
                y-=1;
                continue;
            }
            //一直走上直到见顶
            while (x-1>=0&&ans[x-1][y]==0){
                x--;
                i++;
                ans[x][y]=i;
            }
            //进入下一圈
            y++;
        }
        return ans;
    }
}
