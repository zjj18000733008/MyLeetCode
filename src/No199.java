import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/9/3
 */
public class No199 {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了89.05% 的用户
     * 内存消耗：37.2 MB, 在所有 Java 提交中击败了31.79% 的用户
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if (i == size - 1) {
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return list;
    }
}
