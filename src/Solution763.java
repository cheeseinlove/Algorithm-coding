import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-11 23:21
 * @Description:
 */
public class Solution763 {
    //贪心的思想，只要尽可能的短那么总的分片数量就更多，使单个区间最短的方式就是刚好满足遍历过程中该区间的字母只出现在该区间，所以只需要记录map
    // 每个字母最后出现的下标，并且在遍历中动态更新该区间遍历的终止阈值就好了
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans=new ArrayList<>();
        Map<Character,Integer> lastCache=new HashMap<>();
        for(int i=0;i<S.length();i++){
            lastCache.put(S.charAt(i),i);
        }
        int i=0;
        while (i<S.length()){
            int end=lastCache.get(S.charAt(i));
            for(int j=i;j<=end;j++){
                end=Math.max(lastCache.get(S.charAt(j)),end);
            }
            ans.add(end-i+1);
            i=end+1;
        }
        return ans;
    }
}
