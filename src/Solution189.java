/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-13 12:40
 * @Description:
 */
public class Solution189 {
    public static void main(String[] args) {
        int nums[] = new int[]{1, 2};
        int k = 3;
        rotate(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len<2){
            return ;
        }
        k = k % len;
        //使用numsK的原因是，前k个数可能在交换中被覆盖
        int numsK[]=new int[k];
        for(int i=0;i<k;i++){
            numsK[i]=nums[i];
        }
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                int index=i;
                int temp=numsK[index];
                int temp2 = 0;
                while (index < len) {
                    temp2=nums[(index+k)%len];
                    nums[(index+k)%len]=temp;
                    temp=temp2;
                    index+=k;
                }
            }
        }
    }
}
