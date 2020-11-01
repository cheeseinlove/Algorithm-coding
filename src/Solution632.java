import java.util.Arrays;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-21 23:40
 * @Description:
 */
public class Solution632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[]ans = new int[2];
        int size = 0;
        for (List<Integer> list : nums) {
            size += list.size();
        }
        int[][] sort_nums = new int[size][2];
        int index = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                sort_nums[index][0] = num;
                sort_nums[index][1] = i;
                index++;
            }
        }
        Arrays.sort(sort_nums, (o1, o2) -> (o1[0] - o2[0]));

        int[] count = new int [nums.size()];
        int k = 0;
        int i = 0;
        for(int j = 0; j < size; j++){
            //如果是新加入的类型则k++
            if(0 == count[sort_nums[j][1]]++) k++;
            //若达到了总类型数则左指针i可以右移
            if(k == nums.size()){
                //左移必须是左指针个数目大于1,这样才能保证总数目为num.size，否则右指针移动
                while(count[sort_nums[i][1]] > 1)count[sort_nums[i++][1]]--;
                if((ans[0] == 0 && ans[1] == 0 )|| ans[1] - ans[0] > sort_nums[j][0] - sort_nums[i][0]){
                    ans = new int[]{sort_nums[i][0],sort_nums[j][0]};
                }
            }
        }

        return ans;
    }

}
