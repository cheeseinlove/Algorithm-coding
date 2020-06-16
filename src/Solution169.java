import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-12 09:20
 * @Description:
 */
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
public class Solution169 {
    public static void main(String[] args) {

    }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        return nums[len/2];
    }
}
