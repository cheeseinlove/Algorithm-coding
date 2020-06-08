package tools;

/**
 * @Author liuxun05
 * @create 2020/2/20 22:00
 **/
//字符串型前缀树
public class TrieNodeServer {
    public class TrieNode {
        public TrieNode[] children=new TrieNode[26];
        public boolean isEnd;
    }
    public TrieNode root=new TrieNode();
    public void insert(String word){
        TrieNode cur=root;
        for (int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if (cur.children[index]!=null){
                cur.children[index]=new TrieNode();
            }
            cur=cur.children[index];
        }
        cur.isEnd=true;
    }
}
