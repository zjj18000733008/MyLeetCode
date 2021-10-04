import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/8/16
 */
public class No94 {

    private List<Integer> list = new ArrayList<>();

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.5 MB, 在所有 Java 提交中击败了79.89% 的用户
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return list;
        }

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);

        return list;
    }

    public void inorder(TreeNode root){

        if (root == null) {
            return ;
        }

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
