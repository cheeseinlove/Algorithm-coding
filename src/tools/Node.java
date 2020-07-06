package tools;

import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-01 13:14
 * @Description:
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
