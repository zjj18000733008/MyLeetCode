import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/8/18
 */
public class No114 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了42.78% 的用户
     * 内存消耗：37.8 MB, 在所有 Java 提交中击败了63.59% 的用户
     * @param root
     */
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        preOrder(root, queue);
        TreeNode pre = root;
        queue.pop();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            pre.right = queue.pop();
            pre=pre.right;
        }
    }

    public void preOrder(TreeNode root, Queue queue) {
        if (root == null) {
            return;
        }
        queue.add(root);
        preOrder(root.left, queue);
        preOrder(root.right, queue);
        root.left = null;
        root.right = null;
    }

    @Test
    public void test(){
        TreeNode root = BinaryTreeUtils.buildTree(new int[] {1, 2, 5, 3, 4, -1, 6}, -1);
        flatten(root);
    }
}
