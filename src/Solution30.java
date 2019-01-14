import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 */
public class Solution30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indexes = new ArrayList<>();
        if (words.length == 0)
            return indexes;
        //记录数组中每个单元所出现的个数
        Map<String, Integer> counts = new HashMap<>();

        for (String word : words) {
            //因为计数时map会自动覆盖掉已存在的相同key，所以调用getOrDefault（方法）
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        //words的元素长度都相同
        int n = s.length(), num = words.length, len = words[0].length();
        for (int i = 0; i < n - num * len + 1; i++) {
            //i是迭代字符串的起始位置，当i>=n-num*len+1的时候  所剩字符已小于要求的字符串 长度，结束
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                //该循环迭代寻找字符串，i为起始索引
                String word = s.substring(i + j * len, i + (j + 1) * len);      //每次找的是从i开始，长度为len的一个字符串
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);    //将迭代到的字符串及个数放入Map中，与要求的Map进行对比
                    //每次每个单词匹配成功后检查“单词是否用完了”
                    if (seen.get(word) > counts.get(word))
                        break;
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;

    }

    public static void main(String... args) {
        String s = "barfoothefoobarman";
        String words[] = new String[]{"foo", "bar"};
        List<Integer> res = findSubstring(s, words);
        for (int i = 0; i < res.size(); i++)
            System.out.print(res.get(i) + " ");
    }
}
