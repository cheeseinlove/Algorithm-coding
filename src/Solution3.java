import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-11 17:43
 * @Description:
 */
public class Solution3 {
    public static void main(String[] args) {
        System.out.println(findMaxLenghtOfNonRepeatedStr("abba"));
    }
    public static int findMaxLenghtOfNonRepeatedStr(String s) {
        if (s.length()==0){
            return 0;
        }
        int maxLen = Integer.MIN_VALUE;
        Map<String,Integer> strIndexMap=new HashMap<>();
        int left=0;
        int right=0;
        int oldIndex=0;
        while (right<s.length()){
            if (strIndexMap.containsKey(String.valueOf(s.charAt(right)))){
                oldIndex=strIndexMap.get(String.valueOf(s.charAt(right)));
                if (oldIndex>=left)
                left=oldIndex+1;
            }
            strIndexMap.put(String.valueOf(s.charAt(right)),right);
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;


    }
}
