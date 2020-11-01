import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-16 16:51
 * @Description:
 */
public class Solution316 {
    static int count[];

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bddbccd"));
    }
    //保证重复字符串的相对顺序最小从而使整个字典序最小,贪心+递归
    public static String removeDuplicateLetters(String s) {
        count = new int[26];
        return solve(s);
    }
    //核心思路是找到某个元素i出现完时遍历的所有元素中的最小元素作为头
    //因为在遍历时候某个元素用完了代表他的位置已经固定了，那么他之前的最小元素一定在最终结果中在他之前，使用pos指针记录这个元素位置
    //显然pos的位置固定后剩下的元素中要去除掉pos
    //为什么i这时不能直接拼到结果中，因为这是一个贪心如acbc这种，并不能第一步直接拼ac
    public static String solve(String s) {
        if (s.length()<2){
            return s;
        }
        Arrays.fill(count,0);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }
        int pos=0;
        for(int i=0;i<s.length();i++){
            //记录最小元素
            if (s.charAt(i)<s.charAt(pos)){
                pos=i;
            }
            count[s.charAt(i)-'a']--;
            //如果用完了
            if(count[s.charAt(i)-'a']==0){
                break;
            }
        }
        char tar= s.charAt(pos);
        return tar+solve(s.substring(pos+1).replace(""+tar,""));
    }
}
