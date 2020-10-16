import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-22 16:05
 * @Description:
 */
//假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
//
// 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
//
// 示例 1:
//
// 输入:
//big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
//small = [1,5,9]
//输出: [7,10]
//
// 示例 2:
//
// 输入:
//big = [1,2,3]
//small = [4]
//输出: []
//
// 提示：
//
//
// big.length <= 100000
// 1 <= small.length <= 100000
//
// Related Topics Sliding Window
// 👍 10 👎 0
public class Interview1718 {
    public static void main(String[] args) {
        int big[]=new int[]{7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
        int small[]=new int[]{1,5,9};
        int ans[]=shortestSeq(big,small);
        System.out.println(ans[0]+"  "+ans[1]);
    }
    public static int[] shortestSeq(int[] big, int[] small) {
        int[] ans = new int[2];
        int minLen = Integer.MAX_VALUE;
        Set<Integer> target = new HashSet<>();
        Map<Integer, Integer> cur = new HashMap<>();
        for (int i : small) {
            target.add(i);
        }
        int l = 0;
        int r = -1;
        while (r < big.length) {
            //数量不够，右移
            if (cur.size() < target.size()) {
                r++;
                if (r < big.length&&target.contains(big[r])) {
                    cur.put(big[r], cur.getOrDefault(big[r], 0) + 1);
                }
            } else {

                while (cur.size() >= target.size()) {
                    //更新最小长度
                    if (r - l + 1 < minLen) {
                        minLen = r - l + 1;
                        ans[0] = l;
                        ans[1] = r;
                    }
                    if (target.contains(big[l])) {
                        cur.put(big[l], cur.get(big[l]) - 1);
                        if (cur.get(big[l]) == 0) {
                            cur.remove(big[l]);
                        }
                    }
                    l++;
                }
            }


        }

        if (minLen == Integer.MAX_VALUE) {
            return new int[0];
        }
        return ans;
    }


}
