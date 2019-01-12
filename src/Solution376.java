public class Solution376 {
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int len = nums.length, ans = len, flag = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] - nums[i - 1] == 0) ans--;
            else if (nums[i] - nums[i - 1] > 0) {
                if (flag == 1)
                    ans--;
                else flag = 1;
            } else if (nums[i] - nums[i - 1] < 0) {
                if (flag == -1)
                    ans--;
                else flag = -1;
            }
        }
        return ans;
    }
    /*
    本题采用自底向上的动态规划方法，
    分别创建数组up[n]，down[n]来存储遍历到字串的第i个元素时，
    最后一次是up和down的蛇形字串长度
    最后一次要么是up要么是down。
     */
    public static int  w2(int []nums){
        int up[]=new int[nums.length];
        int down[]=new int [nums.length];
        if(nums.length==0)
            return 0;
        //初始化
        for(int i=0;i<nums.length;i++){
            up[i]=1;
            down[i]=1;
        }
        for (int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                up[i]=down[i-1]+1;
                down[i]=down[i-1];
            }
            else if(nums[i]<nums[i-1]){
                up[i]=up[i-1];
                down[i]=up[i-1]+1;
            }
            else{
                up[i]=up[i-1];
                down[i]=down[i-1];
            }
        }




        return Math.max(up[nums.length-1],down[nums.length-1])
;    }

    public static void main(String... args) {
        int a[] = new int[]{1, 17, 5, 10, 13, 5};
//        System.out.print(wiggleMaxLength(a));
        System.out.print(w2(a));

    }
}
