import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/8/17
 */
public class No103 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了96.46% 的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了42.08% 的用户
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) {
            return lists;
        }
        boolean flag=false;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (flag) {
                    TreeNode node = queue.pollLast();
                    list.add(node.val);
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                }else{
                    TreeNode node = queue.pollFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                }
            }
            lists.add(list);
            flag= !flag;
        }

        return lists;
    }

}
