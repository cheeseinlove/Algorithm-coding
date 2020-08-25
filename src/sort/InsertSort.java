package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-10 22:55
 * @Description:
 */
public class InsertSort {
    public static void main(String[] args) {
        List<Integer> ans=new ArrayList<>(18);
        ans.add(1);
        ans.add(1,0);
        System.out.println(ans.get(0));
        int nums[] = new int[]{6,3,5,1,5,7,2,9};
        sort(nums);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    public static void sort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            //此次要往前插入的数
            int temp = nums[i];
            while (j >= 0 && nums[j] >= temp) {
                //给temp腾位子
                nums[j + 1] = nums[j];
                j--;
            }
            //放temp
            nums[j + 1] = temp;
        }

    }
}
