import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/8/17
 */
public class No102 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了93.23% 的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了42.56% 的用户
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> lists = new ArrayList<>();

        if (root == null) {
            return lists;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }

}
