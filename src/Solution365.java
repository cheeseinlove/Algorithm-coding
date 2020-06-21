import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-19 21:06
 * @Description:
 */
public class Solution365 {
    public static void main(String[] args) {
        System.out.println(canMeasureWater2(1,2,3));
    }
    public static boolean canMeasureWater(int x, int y, int z) {
        if(x==z||y==z||x+y<=z){
            if(x+y<z){
                return false;
            }
            return true;
        }
return z%gcd(x,y)==0;

    }
    public static int gcd(int x,int y){

        if (x<y){
            int temp=x;
            x=y;
            y=temp;
        }
        if (y==0){
            return x;
        }
        while (x%y!=0){
            int temp=x;
            x=y;
            y=temp%y;
        }
        return y ;
    }
    private static class State {
        private int x;
        private int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "State{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return x == state.x &&
                    y == state.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    private static List<State> getNextStates(int curX, int curY, int x, int y) {
        // 最多 8 个对象，防止动态数组扩容，不过 Java 默认的初始化容量肯定大于 8 个
        List<State> nextStates = new ArrayList<>(8);

        // 按理说应该先判断状态是否存在，再生成「状态」对象，这里为了阅读方便，一次生成 8 个对象

        // 以下两个状态，对应操作 1
        // 外部加水，使得 A 满
        State nextState1 = new State(x, curY);
        // 外部加水，使得 B 满
        State nextState2 = new State(curX, y);

        // 以下两个状态，对应操作 2
        // 把 A 清空
        State nextState3 = new State(0, curY);
        // 把 B 清空
        State nextState4 = new State(curX, 0);

        // 以下四个状态，对应操作 3
        // 从 A 到 B，使得 B 满，A 还有剩
        State nextState5 = new State(curX - (y - curY), y);
        // 从 A 到 B，此时 A 的水太少，A 倒尽，B 没有满
        State nextState6 = new State(0, curX + curY);

        // 从 B 到 A，使得 A 满，B 还有剩余
        State nextState7 = new State(x, curY - (x - curX));
        // 从 B 到 A，此时 B 的水太少，B 倒尽，A 没有满
        State nextState8 = new State(curX + curY, 0);

        // 没有满的时候，才需要加水
        if (curX < x) {
            nextStates.add(nextState1);
        }
        if (curY < y) {
            nextStates.add(nextState2);
        }

        // 有水的时候，才需要倒掉
        if (curX > 0) {
            nextStates.add(nextState3);
        }
        if (curY > 0) {
            nextStates.add(nextState4);
        }

        // A往B倒水，倒满了，有剩余才倒
        if (curX - (y - curY) > 0) {
            nextStates.add(nextState5);
        }
        if (curY - (x - curX) > 0) {
            nextStates.add(nextState7);
        }

        // 倒过去倒不满才倒
        if (curX + curY < y) {
            nextStates.add(nextState6);
        }
        if (curX + curY < x) {
            nextStates.add(nextState8);
        }
        return nextStates;
    }

    public static boolean canMeasureWater2(int x, int y, int z) {
        // 特殊情况
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }


        Queue<State> queue=new LinkedList<>();
        Set<State> visited=new HashSet<>();
        State initState=new State(0,0);
        queue.offer(initState);
        visited.add(initState);
        while (queue.size()!=0){
            int size=queue.size();
            for(int i=0;i<size;i++){
            State curState=queue.poll();
            if (curState.getX()==z||curState.getY()==z|| curState.getX() + curState.getY() == z){
                return true;
            }
                List<State> nextState=getNextStates(curState.getX(),curState.getY(),x,y);
                for(State s:nextState){
                    if (!visited.contains(s)){
                        visited.add(s);
                        queue.offer(s);
                    }
                }

            }
        }
        return false;
    }

}
