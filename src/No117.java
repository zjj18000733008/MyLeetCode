import java.util.LinkedList;

import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/9/3
 */
public class No117 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了63.60% 的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了79.21% 的用户
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

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return root;
    }

    @Test
    public void test(){
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
