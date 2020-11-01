package week_competition;

/**
 * @Author liuxun05
 * @create 2020/11/1 10:45
 **/
public class Solution5555 {
    public static void main(String[] args) {
        System.out.println(countVowelStrings(2));
    }
    public static int countVowelStrings(int n) {
     String s[]=new String[]{"a","e","i","o","u"};

     return dfs(0,n,0,s);
    }
    public static int dfs(int cur,int n,int index,String s[]){
        if (cur==n){
            return 1;
        }
        if (n-cur>s.length-index){
            return 0;
        }
        int flag=0;
        for(int i=index;i<s.length;i++){
            int sum=dfs(cur+1,n,i+1,s);
            flag+=sum;
        }
        return flag;
    }
}
