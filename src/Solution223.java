/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-13 23:06
 * @Description:
 */
public class Solution223 {
    //还有种做法，抽象化坐标遍历两个矩形，坐标值为1就ans++坐标值为2ans--，
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int lx = Math.max(A, E);
        int by = Math.max(B, F);
        int rx = Math.min(C, G);
        int ty = Math.min(D, H);

        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        //若无重叠
        if (E > C || F > D || G < A || H < B) {
            return area1 + area2;
        }

        return area1 + area2 - (rx - lx) * (ty - by);


    }
}
