/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-16 08:59
 * @Description:
 */
public class Solution208 {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println( trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));   ;     // 返回 true

    }

    static class Trie {
        private TrieNode root;

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isWord = false;
        }


        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Trie.TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                if (cur.children[word.charAt(i)-'a'] == null) {
                    cur.children[word.charAt(i)-'a'] = new TrieNode();
                }
                cur = cur.children[word.charAt(i)-'a'];
            }
            cur.isWord = true;

        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode cur = root;

            for (int i = 0; i < word.length(); i++) {
                if (cur.children[word.charAt(i)-'a'] == null) {
                    return false;
                }
                cur = cur.children[word.charAt(i)-'a'];
            }

            return cur.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode cur = root;

            for (int i = 0; i < prefix.length(); i++) {
                if (cur.children[prefix.charAt(i)-'a'] == null) {
                    return false;
                }
                cur = cur.children[prefix.charAt(i)-'a'];
            }

            return true;
        }
    }
}