import java.util.ArrayList;
import java.util.List;

/**
 * @Author liuxun05
 * @create 2020/2/19 23:15
 **/
//给定一个不含重复单词的列表，编写一个程序，返回给定单词列表中所有的连接词。

//连接词的定义为：一个字符串完全是由至少两个给定数组中的单词组成的
public class Solution472 {
    public static void main(String[] args) {
       List<String> list=findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"});
       for (String s:list){
           System.out.println(s);
       }
    }
    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    //前缀树词根
    static  TrieNode node = new TrieNode();
    public static void insert(String s) {
        TrieNode cur = node;
        for(int i = 0; i < s.length(); i++)
        {
            int pos = s.charAt(i) - 'a';
            if(cur.children[pos] == null)
                cur.children[pos] = new TrieNode();
            cur = cur.children[pos];
        }
        cur.isWord = true;
    }

    static List<String> res = new ArrayList<>();
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        if(words.length == 0)
            return res;
//构建前缀树
        for(String word: words)
        {
            if(word.length() != 0)
                insert(word);
        }
//dfs
        for(String word: words)
        {
            if(dfs(word, node, 0, 0))
                res.add(word);
        }
        return res;
    }

    public static boolean dfs(String word, TrieNode cur, int count, int index) {
        for(int i = index; i < word.length(); i++)
        {
            int pos = word.charAt(i) - 'a';
            if(cur.children[pos] == null)
                return false;
            cur = cur.children[pos];
            //若当前遍历到是一个单词结尾则从词根继续遍历，index记录当前遍历位置
            if(cur.isWord && dfs(word, node, count + 1, i + 1))
                return true;
        }
        //若当前是整个单词的结尾
        return count > 0 && cur.isWord;
    }


}
