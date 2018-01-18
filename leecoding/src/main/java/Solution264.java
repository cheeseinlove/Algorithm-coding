public class Solution264 {
    public static int nthUglyNumber(int n) {
        int a[]=new int[n];
        a[0]=1;
        int i=0,j=0,k=0;
        int next=1;
        while (next<n){
            a[next]=Math.min(a[i]*2,Math.min(a[j]*3,a[k]*5));
            if (2*a[i]==a[next])
                i++;
            if (3*a[j]==a[next])
                j++;
            if (5*a[k]==a[next])
                k++;

            next++;


        }

        return a[n-1];
    }
    public static void main(String...args){
        System.out.print(nthUglyNumber(11));

    }
}
