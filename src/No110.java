/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/8/18
 */
public class No110 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了86.02% 的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了82.90% 的用户
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left)-depth(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root){
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right))+1;
    }
}
