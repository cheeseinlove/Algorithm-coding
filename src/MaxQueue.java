import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-22 09:35
 * @Description:
 */
public class MaxQueue {
    public static void main(String[] args) {
        MaxQueue maxQueue=new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        maxQueue.max_value();
        maxQueue.pop_front();
        maxQueue.max_value();
    }
    private Deque<Integer> serialQ = new LinkedList<>();
    private Deque<Integer> valueQ = new LinkedList<>();

    public MaxQueue() {

    }

    public int max_value() {
        return serialQ.peekFirst() == null ? -1 : serialQ.peekFirst();
    }

    public void push_back(int value) {
        valueQ.add(value);
        while (!serialQ.isEmpty() && serialQ.peekLast() < value) {
            serialQ.removeLast();
        }
        serialQ.add(value);
    }

    public int pop_front() {
        if (valueQ.isEmpty()){
            return -1;
        }
        int ans=valueQ.pollFirst();
        if (ans==serialQ.peekFirst()){
            serialQ.pollFirst();
        }
        return ans;
    }
}