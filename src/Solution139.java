import java.util.List;

public class Solution139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
    boolean dp[]=new boolean[s.length()+1];
    dp[s.length()]=true;
for (int i=s.length()-1;i>=0;i--){
    for (int j=s.length();j>i;j--){
        if (dp[j]&&wordDict.contains(s.substring(i,j)))
            dp[i]=true;
    }
}
return dp[0];

    }



        public static int maxProduct(int[] nums) {
                if (nums == null || nums.length == 0) {
                    return 0;
                }
                int max = nums[0], min = nums[0], result = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    int temp = max;
                    max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
                    min = Math.min(Math.min(temp * nums[i], min *nums[i]), nums[i]);
                    if (max > result) {
                        result = max;
                    }
                }
                return result;
        }

    public static void main(String ...args){
int a[]=new int[]{2,-5,-2,-4,3};
System.out.print(maxProduct(a));
    }
}
