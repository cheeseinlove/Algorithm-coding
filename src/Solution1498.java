import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-22 22:07
 * @Description:
 */
public class Solution1498 {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int mod=1000000007;
        int[] storage=new int[nums.length];
        storage[0]=1;
        for(int i=1;i<nums.length;i++) {
            storage[i]=(2*storage[i-1])%mod;
        }

        int left=0;
        int right=nums.length-1;
        int res=0;
        while(left<=right) {
            if(nums[left]+nums[right]<=target) {
                res=(res+storage[right-left])%mod;
                left++;
            }else {
                right--;
            }
        }
        return res;
    }


}
