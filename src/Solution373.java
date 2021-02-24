import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-02-03 23:38
 * @Description:
 */
public class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        if (nums1.length==0||nums2.length==0){
            return ans;
        }
        int usedNum2Index[]=new int[nums1.length];
        for(int i=0;i<k;i++){
            List<Integer> list=new ArrayList<>();
            int min=Integer.MAX_VALUE;
            int l=-1;
            for(int j=0;j<usedNum2Index.length;j++){
                if (usedNum2Index[j]<nums2.length&&nums1[j]+nums2[usedNum2Index[j]]<min){
                    min=nums1[j]+nums2[usedNum2Index[j]];
                    l=j;
                }
            }
            if (l!=-1){
                list.add(nums1[l]);
                list.add(nums2[usedNum2Index[l]]);
                usedNum2Index[l]++;
                ans.add(list);
            }

        }
        return ans;
    }
}
