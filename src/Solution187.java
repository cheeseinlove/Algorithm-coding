import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-07 23:41
 * @Description:
 */
public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> ans=new HashSet<>();
        if (s.length()<=10){
            return new ArrayList<>();
        }
        Set<String> set=new HashSet<>();
        for(int i=0;i+10-1<s.length();i++){
            if (set.contains(s.substring(i,i+10))){
                ans.add(s.substring(i,i+10));
            }else {
                set.add(s.substring(i,i+10));
            }
        }


        return new ArrayList<>(ans);
    }
}
