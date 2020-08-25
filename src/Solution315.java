import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-10 22:12
 * @Description:
 */
public class Solution315 {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new LinkedList<>();
        //使用链表头插法
        LinkedList<Integer> res = new LinkedList<>();
        int len = nums.length;
        //反向插入排序
        for (int i = len - 2; i >= 0; i--) {
            int j = i + 1, temp = nums[i];
            while (j < len && nums[j] >= temp) {
                nums[j - 1] = nums[j];
                j++;
            }
            nums[j - 1] = temp;
            //len - j就表示计数个数
            res.addFirst(len - j);
        }
        //添加最后一个数
        res.add(0);
        //LinkedList也是List
        return res;
    }

    public List<Integer> countSmaller2(int[] nums) {
        if (nums == null || nums.length == 0) return new LinkedList<>();
        //使用链表头插法
        LinkedList<Integer> res = new LinkedList<>();
        int len = nums.length;
        List<Integer> sort = new ArrayList<>(len);
        for (int i = len - 1; i >= 0; i--) {
            int index = binarySearch(sort, nums[i]);
            sort.add(index, nums[i]);
            res.addFirst(index);
        }
        return res;
    }

    public int binarySearch(List<Integer> nums, int target) {


        int left = 0;
        //初始取右区间
        int right = nums.size() ;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid ;
            }

        }
        return left;
    }
}
