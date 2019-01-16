/*
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
public class Solution36 {
    public static boolean isValidSudoku(char[][] board) {
            //记录每一行的数据
            boolean row[][]=new boolean[9][10];
            //记录每一列的数据
            boolean col[][]=new boolean[9][10];
            //记录3x3格子数据
            boolean  block[][]=new boolean[9][10];
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[i].length;j++){
                    if (board[i][j]!='.'){
                        int num=board[i][j]-'0';
                        if(row[i][num]||col[j][num]||block[(i/3)*3+j/3][num])
                        return false;
                        else {
                            row[i][num]=true;
                            col[j][num]=true;
                            block[(i/3)*3+j/3][num]=true;
                        }

                    }

                }
            }
            return true;
    }

    public static void main(String... args) {
        char sudu[][] = new char[][]{
                {'5', '7', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7' ,'9'}
        };
 System.out.print(isValidSudoku(sudu));
    }
}
