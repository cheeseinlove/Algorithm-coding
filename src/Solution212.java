import java.util.LinkedList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-18 09:36
 * @Description:
 */
public class Solution212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new LinkedList<>();
        if (board.length == 0 || board[0].length == 0 || words.length == 0) {
            return ans;
        }
        //构建字典树
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        //进行dfs
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(ans, board, trie, "", i, j);
            }
        }
        return ans;
    }

    private void dfs(List<String> ans, char[][] board, Trie trie, String str, int x, int y) {
        if (!legal(board, x, y) || trie == null) {
            return;
        }
        char ch = board[x][y];
        if (ch == '.') {
            return;
        }
        str += ch;
        trie = trie.getArr()[ch - 'a'];
        if (trie != null && trie.getEnd()) {
            ans.add(str);
            //防止一个单词背重复添加
            trie.setEnd(false);
        }
        //减去了状态数组的使用
        board[x][y] = '.';
        dfs(ans, board, trie, str, x - 1, y);
        dfs(ans, board, trie, str, x + 1, y);
        dfs(ans, board, trie, str, x, y - 1);
        dfs(ans, board, trie, str, x, y + 1);
        board[x][y] = ch;
    }

    private boolean legal(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}


//实现字典树
class Trie {

    private Trie[] arr;

    private boolean end;

    Trie() {
        arr = new Trie[26];
    }

    public void insert(String word) {
        if (word == null || "".equals(word)) {
            return;
        }
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (trie.arr[index] == null) {
                trie.arr[index] = new Trie();
            }
            trie = trie.arr[index];
        }
        trie.end = true;
    }

    public boolean getEnd() {
        return end;
    }

    public Trie[] getArr() {
        return arr;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
