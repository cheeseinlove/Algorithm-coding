/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-12 22:17
 * @Description:
 */
//这题有个隐含条件，如果存在这样的字符串，那么一定是给定字符串之一
public class Solution522 {
    public static void main(String[] args) {
        String[]s=new String[]{"aaa","aa","a"};
        System.out.println(findLUSlength(s));
    }
    public static int findLUSlength(String[] strs) {
      int max=0;
      for(int i=0;i<strs.length;i++){
          boolean flag=false;
          for(int j=0;j<strs.length;j++){
              if (j!=i){
                  if (isSubSequence(strs[j],strs[i])){
                      flag=true;
                      break;
                  }
              }
          }
          if (!flag){
              max=Math.max(max,strs[i].length());
          }
      }

      return max==0?-1:max;

    }
    //判断b是不是a子序列
    public static boolean isSubSequence(String a,String b){
        if (a.equals(b)){
            return true;
        }
        if (b.length()>=a.length()){
            return false;
        }

        int j=0;
        for(int i=0;i<a.length();i++){
            if (a.charAt(i)==b.charAt(j)){
                for(int k=i;j<b.length()&&k<a.length();k++){
                    if (a.charAt(k)==b.charAt(j)){
                        j++;
                    }
                }
                if (j==b.length()){
                    return true;
                }
                j=0;
            }
        }
        return false;
    }
}
