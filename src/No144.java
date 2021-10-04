import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/8/18
 */
public class No144 {

    private List<Integer> list=new ArrayList<>();

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了90.84% 的用户
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root){

        if (root == null) {
            return list;
        }

        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return list;
    }
}
