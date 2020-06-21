import java.util.HashSet;
import java.util.Set;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-19 13:26
 * @Description:
 */
public class Solution202 {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n){
        Set<Integer> duplicateList=new HashSet<>();
        while (true){
            if (duplicateList.contains(n)){
                return false;
            }
            duplicateList.add(n);
            int nextN=calculatePowSum(n);
            if (nextN==1){
                return true;
            }
            n=nextN;
        }

    }

    public static int calculatePowSum(int num){
        int ans=0;
        while (num!=0){
            ans+=Math.pow(num%10,2);
            num/=10;
        }
        return ans;
    }
}
