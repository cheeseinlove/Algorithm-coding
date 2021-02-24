/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-28 22:02
 * @Description:
 */
public class Solution1706 {
    public int[] findBall(int[][] grid) {
      int []ans=new int[grid[0].length];
      for(int i=0;i<grid[0].length;i++){
          dfs(i,0,i,ans,grid);
      }

      return ans;
    }
    public void dfs(int begin,int x,int y,int []ans,int [][]grid){
        if (x==grid.length){
            ans[begin]=y;
            return;
        }
        if (grid[x][y]==1){
            if (y+1<grid[0].length&&grid[x][y+1]==1){
                dfs(begin,x+1,y+1,ans,grid);
            }else {
                ans[begin]=-1;
            }
        }else {
            if (y-1>=0&&grid[x][y-1]==-1){
                dfs(begin,x+1,y-1,ans,grid);
            }else {
                ans[begin]=-1;
            }
        }
    }
}
