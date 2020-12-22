/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-16 21:16
 * @Description:
 */
public class Solution260 {
    //只能两个数字只出现一次，其余都出现两次
    public int[] singleNumber(int[] nums) {
        int[] ans=new int[2];
        //sum最终的值为x,y异或的值
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum^=nums[i];
        }
        int flag = sum & (~(sum - 1));

        for (int i = 0; i < nums.length; i++)
            if ((nums[i] & flag) == 0) ans[0] ^= nums[i];
            else ans[1] ^= nums[i];

        return ans;
    }
}
