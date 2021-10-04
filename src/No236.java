import sun.reflect.generics.tree.Tree;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/9/6
 */
public class No236 {

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了68.38% 的用户
     * 内存消耗：40.4 MB, 在所有 Java 提交中击败了81.52% 的用户
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left == null && right==null) {
            return null;
        } else if (right != null) {
            return right;
        }else if(left!=null){
            return left;
        }

        return null;

    }
}
