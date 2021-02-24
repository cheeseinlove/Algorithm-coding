package week_competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-04 08:50
 * @Description:
 */
public class Solution5642 {
    public int countPairs(int[] deliciousness) {
        Map<Long, Long> map1 = new HashMap<>();
        for(int i: deliciousness){
            map1.put((long)i, map1.getOrDefault((long)i, 0L) + 1);
        }
        List<Long> keyList = new ArrayList<>(map1.keySet());
        long ans = 0;
        for(int i = 0; i < keyList.size() - 1; i++){
            for(int j = i; j < keyList.size(); j++){
                long a = keyList.get(i);
                long b = keyList.get(j);
                if(isPowerOfTwo(a + b)){
                    //自己能组成大餐
                    if(a == b){
                        long tmp = map1.get(b);
                        ans += (tmp * (tmp - 1) / 2);
                    }else{
                        ans += (map1.get(a) * map1.get(b));
                    }
                }
            }
        }
        return (int)(ans % 1000000007);
    }

    public boolean isPowerOfTwo(long n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
