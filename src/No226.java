import java.util.LinkedList;
import java.util.Stack;

import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/8/18
 */
public class No226 {

    public TreeNode invertTree(TreeNode root){

        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);

        while (!queue1.isEmpty()) {
            int size = queue1.size();
            TreeNode left=null;
            TreeNode right=null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue1.pop();

                if (i % 2 == 0) {
                    left=node;
                }else{
                    right=node;
                }
                if (node == null) {
                    queue1.add(null);
                    queue1.add(null);
                    continue;
                }
                queue1.add(node.left);
                queue1.add(node.right);
                if (!queue2.isEmpty() && i%2==1) {
                    TreeNode parent = queue2.pop();
                    parent.left=right;
                    parent.right=left;
                }
                queue2.add(node);
            }
        }
        return root;
    }

    @Test
    public void test(){
        TreeNode root = BinaryTreeUtils.buildTree(new int[] {4, 2, 7, 1, 3, 6, 9}, -1);
        TreeNode invertTree = invertTree(root);
        TreeNode root2 = BinaryTreeUtils.buildTree(new int[] {1, 2,-1}, -1);
        TreeNode invertTree2 = invertTree(root2);

    }
}
