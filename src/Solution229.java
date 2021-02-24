import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-13 23:33
 * @Description:
 */
public class Solution229 {
    //摩尔投票法，是找到最有希望决胜的玩家
    //我们可以这样理解，假设投票是这样的 [A, B, C, A, A, B, C]，ABC 是指三个候选人。
    //
    //第 1 张票，第 2 张票和第3张票进行对坑，如果票都不同，则互相抵消掉；
    //
    //第 4 张票，第 5 张票和第 6 张票进行对坑，如果有部分相同，则累计增加他们的可抵消票数，如 [A, 2] 和 [B, 1]；
    //
    //接着将 [A, 2] 和 [B, 1] 与第 7 张票进行对坑，如果票都没匹配上，则互相抵消掉，变成 [A, 1] 和 `[B, 0] 。
    public List<Integer> majorityElement(int[] nums) {
        // 创建返回值
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        // 初始化两个候选人candidate，和他们的计票
        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;

        // 摩尔投票法，分为两个阶段：配对阶段和计数阶段
        // 配对阶段
        for (int num : nums) {
            // 投票
            if (cand1 == num) {
                count1++;
                continue;
            }
            if (cand2 == num) {
                count2++;
                continue;
            }

            // 如果之前cand1就被抵消为0了则替代cand1
            if (count1 == 0) {
                cand1 = num;
                count1++;
                continue;
            }
            // 如果之前cand2就被抵消为0了则替代cand2
            if (count2 == 0) {
                cand2 = num;
                count2++;
                continue;
            }

            //完成三元组匹配，三元素各减1，新加入的元素只有一个所以不记录
            count1--;
            count2--;
        }

        // 计数阶段
        // 找到了两个候选人之后，需要确定票数是否满足大于 N/3
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (cand1 == num) count1++;
            else if (cand2 == num) count2++;
        }

        if (count1 > nums.length / 3) res.add(cand1);
        if (count2 > nums.length / 3) res.add(cand2);

        return res;
    }

}
