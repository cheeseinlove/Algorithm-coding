import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-23 21:58
 * @Description:
 */
public class Solution118 {
    public static void main(String[] args) {
        generate(5);
    }
    //第k层的索引为i，它的父母为k-1层的i-1,i
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> cur=new ArrayList<>();
            if (i==0){
                cur.add(1);
            }else {
                for(int j=0;j<i+1;j++){
                    if (ans.get(i-1).size()>j&&j-1>=0){
                        cur.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                    }else {
                        cur.add(1);
                    }
                }
            }

            ans.add(cur);
        }
        return ans;
    }
}
