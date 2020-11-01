import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-27 10:11
 * @Description:
 */
public class Solution621 {
    public static void main(String[] args) {
        char []task=new char[]{'A','A','A','B','B','B'};
        System.out.println(leastInterval(task,0));
    }
    public static int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap();
        int max = 0;
        for(char c:tasks){
            int cnt = (map.get(c)==null?0:map.get(c))+1;
            map.put(c,cnt);
            max = Math.max(max,cnt);
        }
        int count = 0;
        for(Character c:map.keySet()){
            if(map.get(c)==max){
                count++;
            }
        }
        //(n+1)*max-1代表最大重复的那个字符除了最后一个循环节的最少长度，然后+有几个最长的长度
        return Math.max(tasks.length,(n+1)*(max-1)+count);
        }


}
