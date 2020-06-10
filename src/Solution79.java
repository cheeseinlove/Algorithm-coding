/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-07 11:16
 * @Description:
 */
public class Solution79 {
    public static void main(String[] args) {
        char board[][] = new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));

    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean used[][] = new boolean[m][n];
        boolean ans = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    used[i][j] = true;
                    ans |= dfs(i, j, board, used, 1, word);
                    used[i][j] = false;
                }
            }
        }
        return ans;

    }

    public static boolean dfs(int x, int y, char[][] board, boolean[][] used, int len, String word) {
         boolean ans=false;
        int m = board.length;
        int n = board[0].length;
         if(len==word.length()){
             return true;
         }
         if (x-1>=0&&!used[x-1][y]&&word.charAt(len)==board[x-1][y]){
             used[x-1][y]=true;
             ans|=dfs(x-1,y,board,used,len+1,word);
             used[x-1][y]=false;
             if (ans){
                 return ans;
             }
         }
        if (x+1<m&&!used[x+1][y]&&word.charAt(len)==board[x+1][y]){
            used[x+1][y]=true;
            ans|=dfs(x+1,y,board,used,len+1,word);
            used[x+1][y]=false;
            if (ans){
                return ans;
            }
        }
        if (y-1>=0&&!used[x][y-1]&&word.charAt(len)==board[x][y-1]){
            used[x][y-1]=true;
            ans|=dfs(x,y-1,board,used,len+1,word);
            used[x][y-1]=false;
            if (ans){
                return ans;
            }
        }
        if (y+1<n&&!used[x][y+1]&&word.charAt(len)==board[x][y+1]){
            used[x][y+1]=true;
            ans|=dfs(x,y+1,board,used,len+1,word);
            used[x][y+1]=false;
            if (ans){
                return ans;
            }
        }

         return ans;
    }
}
