/**
 *  101,100
 * @author JJ
 * @date 2020/7/27 - 19:31
 */
public class No101 {

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        if(root.left==null || root.right==null) return false;
        if(root.left.val!=root.right.val) return false;
        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode n1,TreeNode n2){
        if(n1==null && n2==null) return true;
        if(n1==null || n2==null) return false;
        if(n1.val!=n2.val) return false;
        return isSymmetric(n1.left,n2.right)&& isSymmetric(n1.right,n2.left);
    }


}
