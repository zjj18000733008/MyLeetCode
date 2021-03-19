/**
 * @author JJ
 * @date 2020/8/2 - 21:56
 */
public class No235 {

    /**
     * 利用二叉搜索树的特点，如果p、q的值都小于root，说明p q 肯定在root的左子树中；
     * 如果p q都大于root，说明肯定在root的右子树中，
     * 如果一个在左一个在右 则说明此时的root记为对应的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
    }
}
