import java.util.HashMap;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-01 23:39
 * @Description:
 */
public class Solution982 {
    public int countTriplets(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0, N = A.length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int temp = A[i] & A[j];
                //数组中任何两个数&的频率
                map.put(temp, map.getOrDefault(temp, 0)+1);
            }
        }
        for (int key : map.keySet()) {
            // 一个优化，当key = 0时，数组中任何值与其&运算结果均为0
            if (key == 0) {
                ans += map.get(key) * N;
                continue;
            }
            for (int i = 0; i < N; i++)
                if ((A[i] & key) == 0) ans += map.get(key);
        }

        return ans;
    }


}
