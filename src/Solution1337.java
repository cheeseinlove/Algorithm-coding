import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-25 23:40
 * @Description:
 */
public class Solution1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] tmp = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            tmp[i][0] = i;
            tmp[i][1] = count(mat[i]);
        }
        Arrays.sort(tmp, (o1, o2) -> o1[1] - o2[1]);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = tmp[i][0];
        }
        return res;
    }

    public int count(int nums[]) {
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=(right+left)/2;
            if (nums[mid]==1){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }


}
