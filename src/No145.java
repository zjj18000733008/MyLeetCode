import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/8/18
 */
public class No145 {
    private List<Integer> list=new ArrayList<>();

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.8 MB, 在所有 Java 提交中击败了16.84% 的用户
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root){

        if (root == null) {
            return list;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);

        return list;
    }
}
