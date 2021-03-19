/**
 * @author JJ
 * @date 2020/7/28 - 20:02
 */
public class No112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null || root.val>sum ) return false;
        if(root.left==null && root.right==null){
            return sum==root.val;
        }
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }

    public static void main(String[] args) {

    }
}

