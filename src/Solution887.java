/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-05-18 21:24
 * @Description:
 */
public class Solution887 {
    public static void main(String[] args) {
        int floors = 100;
        int eggs = 2;

        System.out.println(superEggDrop(eggs, floors));
    }


    private static int superEggDrop(int K, int N) {
        int table[][] = new int[K + 1][N + 1];

        // boundary condition:
        // if no floors or 1 floors, only need 0 trails or 1 trails

        for (int i = 0; i <= K; i++) {
            table[i][1] = 1;
            table[i][0] = 0;
        }

        // if only one egg, f(1,k) = k

        for (int j = 0; j <= N; j++) {
            table[1][j] = j;
        }

        // for the rest of cases
        // f( K, floors) = 1+ Max(f( K-1 , floors-1), f( K, floors-x))
        // x is the floor number we choose to drop for current attempt
        // range of i = 1,2,.....,floors,
        for (int i = 2; i <= K; i++) {
            for (int j = 2; j <= N; j++) {

                table[i][j] = Integer.MAX_VALUE; // so important

                for (int floorTriedFirst = 1; floorTriedFirst <= j; floorTriedFirst++) {
                    int res = 1 + Math.max(table[i - 1][floorTriedFirst - 1], table[i][j - floorTriedFirst]);
                    if (res < table[i][j]) {
                        table[i][j] = res;
                    }
                }

            }
        }

        return table[K][N];
    }


}
