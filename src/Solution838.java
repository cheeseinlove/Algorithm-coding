/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-13 23:48
 * @Description:
 */
public class Solution838 {
    public String pushDominoes(String dominoes) {
        for(int i=0,j=0;i<dominoes.length();i++){
            StringBuilder sb=new StringBuilder(dominoes);
            if(dominoes.charAt(i)=='R')//如果是向右推的，找第一个匹配
            {
                for(j=i+1;j<dominoes.length()&&dominoes.charAt(j)=='.';j++);
                int start=j;
                if(j<dominoes.length()&&dominoes.charAt(j)=='L')//如果匹配的是左，两边向中间倒
                    //j-i-1为中间.的长度
                    for(int k=1;k<=(j-i-1)/2;k++){
                        sb.replace(i+k,i+k,"R");
                        sb.replace(j-k,j-k,"L");
                    }
                else //如果匹配的是右或者结尾，向右倒
                {
                    start=j;
                    while(--j>i)
                        sb.replace(j,j,"R");
                }
                i=start-1;//跳过已处理的部分
            }
            else if(dominoes.charAt(i)=='L')//失配，直接向左倒
                for(j=i-1;j>=0&&dominoes.charAt(j)=='.';j--)
                    sb.replace(j,j,"L");
                dominoes=sb.toString();
        }
        return dominoes;
    }
}
