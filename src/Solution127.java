import java.util.*;

/**
 * @Author liuxun05
 * @create 2020/6/8 21:38
 **/
public class Solution127 {
    public static void main(String[] args) {
        List<String> wordList =new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(ladderLength("hit","cog",wordList));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
// 先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        // 图的广度优先遍历，必须使用的队列和表示是否访问过的 visited （数组，哈希表）
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int wordLen = beginWord.length();
        // 包含起点，因此初始化的时候步数为 1
        int step = 1;
        while (!queue.isEmpty()) {

            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                // 依次遍历当前队列中的单词
                String word = queue.poll();
                char[] charArray = word.toCharArray();

                // 修改当前字符的每一个字符
                for (int j = 0; j < wordLen; j++) {
                    // 一轮以后应该重置，否则结果不正确
                    char originChar = charArray[j];
                //遍历所有当前字符可能的下个转化字符的状态
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == originChar) {
                            continue;
                        }

                        charArray[j] = k;
                        String nextWord = String.valueOf(charArray);

                        if (wordSet.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                //因为BFS是按照层次遍历，所以路径最短的层次一定会先遍历到
                                return step + 1;
                            }

                            if (!visited.contains(nextWord)) {
                                queue.add(nextWord);
                                // 注意：添加到队列以后，必须马上标记为已经访问
                                visited.add(nextWord);
                            }
                        }
                    }
                    // 恢复
                    charArray[j] = originChar;
                }
            }
            step++;
        }
        return 0;


    }
}
