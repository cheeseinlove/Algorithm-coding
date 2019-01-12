import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
说明：
字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
示例 1:
输入:
s: "cbaebabacd" p: "abc"
输出:
[0, 6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 示例 2:
输入:
s: "abab" p: "ab"
输出:
[0, 1, 2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class LC438 {
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if(s == null||s.length() == 0||p == null||p.length()==0)
            return result;
        int[] hash = new int[256];
        char[] pp = p.toCharArray();
        for(char i:pp){
            hash[i]++;
        }
        int left = 0, right = 0, count = p.length();
        while(right < s.length())
        {
            if(hash[s.charAt(right++)]-- > 0)  //窗口右移；相应的hash值减小；如果这个位置的Hash值是正的，表示p字符串也包含这个，所以count做减法
                count--;
            if(count == 0)
                result.add(left);//count指示器，为0表示和p对应的hash值完全一致
            if(right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
                //如果当窗口大小一定的时候即窗口大小和需要比较的字符串大小一致的时候，将窗口左边的指针向右边移动，移动的同时左边的字符计数因为在第一个if的地方hash值减小过，所以需要执行对应恢复操作，即：hash值增加，count计数值增加。
                count++;
        }
        return result;




    }
    public  static void main (String...args){
        String s="cbaebabacd";
        String p="abc";
          List<Integer> res=findAnagrams(s,p);
        Iterator it=res.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}
