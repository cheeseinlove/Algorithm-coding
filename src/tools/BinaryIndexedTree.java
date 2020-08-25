package tools;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-24 10:07
 * @Description:
 */
public class BinaryIndexedTree {
    int d[]=new int[10000];
    int preSum[]=new int[10000];
    int n=d.length-1;
    /** 通过原数组a[]初始化前缀和数组和树状数组*/
    public BinaryIndexedTree(int a[]){
        //初始化前缀和
        preSum[0]=d[0]=a[0];
        for(int i=1;i<a.length;i++){
            preSum[i]=preSum[i-1]+a[i];
            //最近lowbit(i)个数的连续数组和
            d[i]=preSum[i] - preSum[i - lowbit(i)];
        }


    }
    public int lowbit(int x){
        return x&(-x);
    }
    public int query(int x){
        int res=0;
        while (x>0){
            res+=d[x];
            x-=lowbit(x);
        }

        return res;
    }
    /**
     * @Description: 原数组a[x]+v
     * @param x
     * @param v
     * @return void
     * @throws
     */
    public void update(int x,int v){

        while (x<=n){
            d[x]+=v;
            x+=lowbit(x);
        }
    }
}
