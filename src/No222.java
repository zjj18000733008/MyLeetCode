import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 *
 * @author zhongjunjie01
 * @Date: 2021/8/19
 */
public class No222 {

    private int count=0;

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：40.9 MB, 在所有 Java 提交中击败了62.37% 的用户
     * @param root
     * @return
     */
    public int countNodes(TreeNode root){
        if (root == null) {
            return 0;
        }
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }

    @Test
    public void test(){
        int countNodes = countNodes(BinaryTreeUtils.buildTree(new int[] {1, 2, 3, 4, 5, 6, -1}, -1));
        Assert.assertEquals(6, countNodes);
    }
}
