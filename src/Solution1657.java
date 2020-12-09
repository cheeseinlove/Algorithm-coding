import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-08 23:42
 * @Description:
 */
public class Solution1657 {
    //只要两个字符串的数量分布一致就可以转换，因为第一种换法可以使字符串内部的数量顺序一致如1131->321,第二种换法可以使数量顺序一致的
    //字符串 变为相同，如3a2b1c->3b2a1c
    public boolean closeStrings(String word1, String word2) {
        if (word1.length()!=word2.length()){
            return false;
        }
        Map<Character,Integer> count1 =new HashMap<>();
        for(int i=0;i<word1.length();i++){
            count1.put(word1.charAt(i),count1.getOrDefault(word1.charAt(i),0)+1);
        }
        int quantity1[]=new int[count1.size()];
        int index=0;
        for(Map.Entry<Character,Integer>entry:count1.entrySet()){
            quantity1[index++]=entry.getValue();
        }
        Map<Character,Integer> count2 =new HashMap<>();
        for(int i=0;i<word2.length();i++){
            //种类不同也不行
            if (!count1.containsKey(word2.charAt(i))){
                return false;
            }
            count2.put(word2.charAt(i),count2.getOrDefault(word2.charAt(i),0)+1);
        }
        int quantity2[]=new int[count2.size()];
         index=0;
        for(Map.Entry<Character,Integer>entry:count2.entrySet()){
            quantity2[index++]=entry.getValue();
        }
        Arrays.sort(quantity1);
        Arrays.sort(quantity2);
        for(int i=0;i<quantity1.length;i++){
            if (quantity1[i]!=quantity2[i]){
                return false;
            }
        }
        return true;
    }
}
