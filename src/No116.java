import java.util.LinkedList;

import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/9/3
 */
public class No116 {

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了39.71% 的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了27.80% 的用户
     * @param root
     * @return
     */
    public Node connect(Node root) {

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!(queue.isEmpty())) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.pop();
                if (node == null) {
                    continue;
                }
                if (i != 0) {
                    pre.next = node;
                }
                if (i == size - 1) {
                    node.next = null;
                }
                pre = node;

                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return root;
    }

    @Test
    public void test() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;
        Node node = connect(n1);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}