import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/8/19
 */
public class No230 {

    int k =0;
    int kth=0;

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了83.54% 的用户
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root,int k){

        this.k=k;
        inOrder(root);
        return kth;
    }

    public void inOrder(TreeNode root){

        if (root == null) {
            return;
        }

        inOrder(root.left);

        k--;
        if(k==0){
            kth=root.val;
        }

        inOrder(root.right);

    }

    @Test
    public void test(){
        int i = kthSmallest(BinaryTreeUtils.buildTree(new int[] {3, 1, 3, -1, 2, -1, -1}, -1), 1);
        Assert.assertEquals(1, i);
    }
}
