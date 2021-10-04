import org.junit.Test;

/**
 * @author JJ
 * @date 2020/8/2 - 21:56
 */
public class No235 {

    /**
     * 利用二叉搜索树的特点，如果p、q的值都小于root，说明p q 肯定在root的左子树中；
     * 如果p q都大于root，说明肯定在root的右子树中，
     * 如果一个在左一个在右 则说明此时的root记为对应的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了77.78% 的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了24.17% 的用户
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root.val >= p.val && root.val <= q.val || root.val <= p.val && root.val >= q.val) {
            return root;
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor2(root.left, p, q);
        } else {
            return lowestCommonAncestor2(root.right, p, q);
        }
    }

    @Test
    public void test(){
        TreeNode node = lowestCommonAncestor2(
                BinaryTreeUtils.buildTree(new int[] {6, 2, 8, 0, 4, 7, 9, -1, -1, 3, 5, -1, -1, -1, -1}, -1),
                new TreeNode(0),
                new TreeNode(5));
    }
}
