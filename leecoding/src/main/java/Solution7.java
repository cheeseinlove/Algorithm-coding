import java.util.ArrayList;
import java.util.List;

class Solution7 {
    public static int nonNegative(int s){
        int result=0;
        int []a=new int [100];
        int j=0;
        int i=0;
        for(;s!=0;i++){
            a[i]=s%10;
            s/=10;
        }
        j=i;
        for(;j>0;j--){
            result+=a[j-1]*(Math.pow(10,i-j));
        }
        return result;
    }
    public static int reverse(int x) {
        if(x > Integer.MAX_VALUE) return 0;
        else if(x < Integer.MIN_VALUE) return 0;
        else if(x<=0){
            return (0-nonNegative(0-x));
        }

        else{
            return  nonNegative(x);
        }


    }
    public static void main(String...agrs){
        System.out.print(reverse(1534236468));
        List<Exception>aa=new ArrayList<>();
        int a[];
        

    }
}