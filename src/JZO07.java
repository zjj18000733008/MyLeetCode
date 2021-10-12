import java.util.Arrays;

import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie
 * @Date: 2021/10/12
 */
public class JZO07 {

    /**
     * 执行用时：15 ms, 在所有 Java 提交中击败了5.58% 的用户
     * 内存消耗：88.5 MB, 在所有 Java 提交中击败了5.03% 的用户
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i]==preorder[0]){
                root.left=buildTree(Arrays.copyOfRange(preorder, 1,i+1 ), Arrays.copyOfRange(inorder, 0, i));
                root.right=buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length), Arrays.copyOfRange(inorder,
                        i+1, inorder.length));
            }
        }
        return root;
    }
    @Test
    public void test(){
        TreeNode root = buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
    }
}
