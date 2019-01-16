/*
编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。
 */
public class Solution37 {
    public static void solveSudoku(char[][] board) {
backTracking(board);
    }
    public static boolean backTracking(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if (board[i][j]=='.'){

                    for (int k=1;k<10;k++){
                        board[i][j]=(char) ('0'+k);
                        //如果当前的赋值没有出错，则深搜下去，且在此为基础上的深搜会影响根位置，正确的数独不会出这个循环
                        if (isValid(board,i,j)&&backTracking(board))
                            return true;
                        //回退
                        board[i][j]='.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
    //当前位置m,n,回溯法最好单独写isValid方法
    public static boolean isValid(char[][] board,int m,int n){
        if (board[m][n]!='.'){
        //验证当前行每一列重复吗
        for(int j=0;j<board[m].length;j++){
            if (j!=n&&board[m][j]==board[m][n])
                return false;
        }
        //验证当前列的每一行重复吗
        for( int i=0;i<board.length;i++){
            if (i!=m&&board[i][n]==board[m][n])
                return false;
        }
        //验证当前3x3格子,当前所在格子编号为key，当前m,n坐标所在的3x3格子左上角顶点为x,y
        int key=(m/3*3+n/3);
        int x=key/3*3;
        int y=(key%3)*3;
        for(int i=x;i<x+3;i++){
            for (int j=y;j<y+3;j++){
                if (i!=m||j!=n)
                    if (board[i][j]==board[m][n])
                        return false;

            }
        }
        }
            return true;
    }
    public  static void main(String...args){
        char sudu[][] = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7' ,'9'}
        };
        solveSudoku(sudu);

//        System.out.print(isValid(sudu,1,4));

        for(int i=0;i<sudu.length;i++){
            for(int j=0;j<sudu[i].length;j++){
//                System.out.print(isValid(sudu,i,j)+" ");

              System.out.print(sudu[i][j]+" ");
            }
            System.out.println();
        }

    }
}
