import java.util.ArrayList;
import java.util.List;

/**
 * @author JJ
 * @date 2020/7/28 - 20:02
 */
public class No112 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了15.13% 的用户
     * @author JJ
     * @date 2021/4/3 11:49
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        return backtrack(root,sum,root.val);
    }

    public boolean backtrack(TreeNode node,int sum,int count){
        if(node.left==null && node.right==null){//是否是叶子结点
            if(count==sum) {
                return true;
            }else{
                return false;
            }
        }

        return (node.left==null?false:backtrack(node.left,sum,count+node.left.val))|| (node.right==null?false:backtrack(node.right,sum,count+node.right.val));

    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left=n2;
        n1.right=n3;
        No112 no = new No112();
        System.out.println(no.hasPathSum(n1, 4));

    }
}

