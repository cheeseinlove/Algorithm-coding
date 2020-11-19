import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-19 18:02
 * @Description:
 */
public class Solution881 {
    public static void main(String[] args) {

    }
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l=0;
        int r=people.length-1;
        int ans=0;
        while (l<r){
            if (people[r]==limit){
                ans++;
                r--;
                continue;
            }
            //若当前最重的和最轻的大于limit,则最重的只能自己走
            if (people[l]+people[r]>limit){
                ans++;
                r--;
                //最优，刚好满足
            }else if(people[l]+people[r]==limit){
                ans++;
                r--;
                l++;
                //若当前最重的和最轻的能一起走，则最大利用是最轻的右边的人和最重的一起，如a1,a2,a3,a4，若a1+a4<limit。若存在a2+a4<limit，则a2+a3<limit，那么a1,a4同船和a1,a3同船结果一样都是用
                //两条船,若不存在a2使得a2+a4<limit成立，那么a1+a4就是最优解。综上只要一直取a1 a4就好了
            }else {
                ans++;
                r--;
                l++;
            }

        }
        //l==r的人单独走
        return l==r?ans+1:ans;
    }
}
