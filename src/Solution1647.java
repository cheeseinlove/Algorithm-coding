import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-08 23:17
 * @Description:
 */
public class Solution1647 {
    public int minDeletions(String s) {
        int ans=0;
        Map<Character,Integer> count =new HashMap<>();
        for(int i=0;i<s.length();i++){
            count.put(s.charAt(i),count.getOrDefault(s.charAt(i),0)+1);
        }
        Set<Integer> filter=new HashSet<>();
        for(Map.Entry<Character,Integer>entry:count.entrySet()){
            while (filter.contains(entry.getValue())){
                entry.setValue(entry.getValue()-1);
                ans++;
            }
            if (entry.getValue()!=0){
                filter.add(entry.getValue());
            }
        }

        return ans;
    }
}
