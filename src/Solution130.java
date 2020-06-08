import jdk.nashorn.internal.runtime.FindProperty;

/**
 * @Author liuxun05
 * @create 2020/5/23 8:52
 **/
public class Solution130 {
    public static void main(String[] args) {
        char board[][]=new char[][]
                       {{'X','O','X','O','X','O','O','O','X','O'},
                        {'X','O','O','X','X','X','O','O','O','X'},
                        {'O','O','O','O','O','O','O','O','X','X'},
                        {'O','O','O','O','O','O','X','O','O','X'},
                        {'O','O','X','X','O','X','X','O','O','O'},
                        {'X','O','O','X','X','X','O','X','X','O'},
                        {'X','O','X','O','O','X','X','O','X','O'},
                        {'X','X','O','X','X','O','X','O','O','X'},
                        {'O','O','O','O','X','O','X','O','X','O'},
                        {'X','X','O','X','X','X','X','O','O','O'}};
//        char board[][] = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
//        char board[][]=new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        solve(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solve(char[][] board) {
        //行数
        int m = board.length;
        if (m<3){
            return ;
        }
        //列数
        int n = board[0].length;

        DSU dsu = new DSU(board);

        for (int i = 0; i < m; i++) {
            int index = 0;
            if (board[i][0] == 'O') {
                index = i * n + 0;
                dsu.isFlag[index] = true;
            }
            if (board[i][n - 1] == 'O') {
                index = i * n + n-1;
                dsu.isFlag[index] = true;

            }
        }
        for (int i = 0; i < n; i++) {
            int index = 0;
            if (board[0][i] == 'O') {
                index = n * 0 + i;
                dsu.isFlag[index] = true;

            }
            if (board[m - 1][i] == 'O') {
                index = n * (m - 1) + i;
                dsu.isFlag[index] = true;

            }
        }
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[i].length - 1; j++) {
                int index = i * n + j;
                if (board[i][j] == 'O') {
                    int index2 = 0;
                    if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                        index2 = (i - 1) * n + j;
                        dsu.union(index2,index );
                    }
                    if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                        index2 = (i) * n + j - 1;
                        dsu.union(index2,index );

                    }
                    if (i + 1 < m && board[i + 1][j] == 'O') {
                        index2 = (i + 1) * n + j;
                        dsu.union(index, index2);

                    }

                    if (j + 1 < n && board[i][j + 1] == 'O') {
                        index2 = (i) * n + j + 1;
                        dsu.union(index, index2);

                    }


                }
            }
        }

        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[i].length ; j++) {
                int index = i * n + j;
                if (board[i][j]=='O'&&!dsu.getFlag(index)){
                    board[i][j]='X';
                }
            }}
    }

    static class DSU {
        int parent[];
        boolean isFlag[];

        public DSU(char[][] board) {
            int n = board[0].length;
            parent = new int[board.length * n];
            isFlag = new boolean[board.length * n];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    parent[i * n + j] = i * n + j;
                }
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            boolean flag=isFlag[x]|isFlag[parent[x]];
            isFlag[parent[x]]=flag;
            isFlag[x]=flag;
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                boolean flag=isFlag[rootX]|isFlag[rootY]|isFlag[x]|isFlag[y];
                parent[rootY] = rootX;
                isFlag[rootX]=flag;
                isFlag[rootY] = flag;
                isFlag[x] = flag;
                isFlag[y] = flag;
            }
        }

        public boolean getFlag(int x) {
            return isFlag[find(x)];
        }
    }
}
